package com.luxoft.springdb.tx.orm;
import java.sql.Date;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.luxoft.springdb.tx.data.repositories.BookDao;
import com.luxoft.springdb.tx.data.repositories.LogDao;
import com.luxoft.springdb.tx.orm.dao.DuplicateBookTitleException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:application-context.xml"})
public class BookDaoImplTest {

	@Autowired
	private BookDao bookDao;

	@Autowired
	private LogDao logDao;

	@Before
	public void clean() {
		bookDao.deleteAll();
		logDao.deleteAll();
	}
	
	@Test
	public void notSupported() {
		// executing in transaction:
		// addLogs() is starting transaction, but addSeparateLogsNotSupported() suspends it 
		try {
			bookDao.addLogs();
		} catch (Exception e) {}
		
		// first record is added in the log even after exception
		logDao.showLogs();		
	}
	
	@Test
	public void supports() {
		// addSeparateLogsSupports is working with transaction
		try {
			logDao.addSeparateLogsSupports();
		} catch (Exception e) {}

		// first record is added in the log even after exception
		logDao.showLogs();		
	}
	
	@Test
	public void mandatory() {
		// get exception because checkTitleDuplicate can be executed only in transaction
		try {
			bookDao.checkTitleDuplicate("Java");
		} catch(Exception e) {
			System.out.println("ERROR! "+e.getMessage());
		}
	}
	
	@Test
	public void never() {
		bookDao.addBook("Java", Date.valueOf(LocalDate.of(2015, 5, 1)));
		// it's safe to call showLogs from no transaction
		logDao.showLogs();
		
		// but prohibited to execute from transaction
		try {
			bookDao.showLogs();
		} catch(Exception e) {
			System.out.println("ERROR! "+e.getMessage());
		}
	}
	
	@Test
	public void requiresNew() {
		// requires new - log message is persisted in the logs even after exception
		// because it was added in the separate transaction
		bookDao.addBook("Java", Date.valueOf(LocalDate.of(2015, 5, 1)));
		bookDao.addBook("Spring", Date.valueOf(LocalDate.of(2016, 3, 1)));
		bookDao.addBook("Spring Data", Date.valueOf(LocalDate.of(2016, 1, 1)));
		
		try {
			bookDao.addBook("Spring", Date.valueOf(LocalDate.of(2016, 3, 1)));
		} catch (DuplicateBookTitleException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Logs: ");
		logDao.findAll().forEach(System.out::println);
		
		System.out.println("List of added books: ");
		bookDao.findAll().forEach(System.out::println);
	}

	@Test
	public void noRollback() {
		// log message is persisted in the logs even after exception
		bookDao.addBookNoRollback("Java", Date.valueOf(LocalDate.of(2015, 5, 1)));
		bookDao.addBookNoRollback("Spring", Date.valueOf(LocalDate.of(2016, 3, 1)));
		bookDao.addBookNoRollback("Spring Data", Date.valueOf(LocalDate.of(2016, 1, 1)));
		
		try {
			bookDao.addBookNoRollback("Spring", Date.valueOf(LocalDate.of(2016, 3, 1)));
		} catch (DuplicateBookTitleException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Logs: ");
		logDao.findAll().forEach(System.out::println);
		
		System.out.println("List of added books: ");
		bookDao.findAll().forEach(System.out::println);
	}

}
