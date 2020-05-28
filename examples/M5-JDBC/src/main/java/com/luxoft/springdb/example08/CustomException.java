package com.luxoft.springdb.example08;

import java.sql.SQLException;

import org.springframework.dao.DataAccessException;

public class CustomException extends DataAccessException{

	private static final long serialVersionUID = -739916394079329729L;
	private String task;
	private String sql;
	private SQLException sqlex;
	
	public CustomException(String task, String sql, SQLException sqlex) {
		super(task, sqlex);
		this.task = task;
		this.sql = sql;
		this.sqlex = sqlex;
	}

	public String getTask() {
		return task;
	}

	public String getSql() {
		return sql;
	}

	public SQLException getSqlex() {
		return sqlex;
	}

}
