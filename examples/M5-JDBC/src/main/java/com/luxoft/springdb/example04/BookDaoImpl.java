package com.luxoft.springdb.example04;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class BookDaoImpl extends JdbcDaoSupport implements BookDao {

	private RowMapper<Book> rowMapper = new RowMapper<Book>() {
		public Book mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Book book = new Book();
			book.setId(resultSet.getInt("id"));
			book.setTitle(resultSet.getString("title"));
			book.setDateRelease(resultSet.getDate("date_release"));
			return book;
		}
	};

	private PreparedStatementSetter getPreparedStatementSetter(final Book book) {
		return new PreparedStatementSetter() {
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				int i = 0;
				preparedStatement.setString(++i, book.getTitle());
				preparedStatement.setDate(++i, new java.sql.Date(book.getDateRelease().getTime()));
			}
		};
	}

	@Override
	public void printAll() {
		String sql = "SELECT * FROM BOOK";
		List<Map<String, Object>> booksList = getJdbcTemplate().queryForList(sql);
		System.out.println(booksList.size());
		System.out.println(booksList);
	}

	@Override
	public void insert(Book book) {
		String sql = "INSERT INTO BOOK (TITLE, DATE_RELEASE) VALUES (?, ?)";
		getJdbcTemplate().update(sql, getPreparedStatementSetter(book));
	}

	@Override
	public Book getById(int id) {
		return getJdbcTemplate().queryForObject("SELECT * FROM BOOK WHERE id=?", rowMapper, id);
	}

	@Override
	public List<Book> getAll() {
		return getJdbcTemplate().query("SELECT * FROM BOOK", rowMapper);
	}

	@Override
	public void update(int id, String title) {
		String sql = "UPDATE BOOK SET TITLE = ? WHERE ID = ?";
		getJdbcTemplate().update(sql, new Object[] { title, id });
	}

	@Override
	public void delete(Book book) {
		String sql = "DELETE FROM BOOK WHERE TITLE = ?";
		getJdbcTemplate().update(sql, new Object[] { book.getTitle() });
	}

}
