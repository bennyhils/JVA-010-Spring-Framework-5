package com.luxoft.springdb.tx.data.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.luxoft.springdb.tx.orm.model.Log;

public class LogDaoImpl implements LogDaoCustom {
	@Autowired
	private LogDao log;

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void log(String message) {
		log.save(new Log(message));
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void addSeparateLogsNotSupported() {
		log.save(new Log("check from not supported 1"));
		throw new RuntimeException();
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void addSeparateLogsSupports() {
		log.save(new Log("check from supports 1"));
	    throw new RuntimeException();
	}

	@Transactional(propagation = Propagation.NEVER)
	public void showLogs() {
		System.out.println("Current log:");
		log.findAll().forEach(System.out::println);
	}

}
