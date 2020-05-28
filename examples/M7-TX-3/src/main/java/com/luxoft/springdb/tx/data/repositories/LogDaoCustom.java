package com.luxoft.springdb.tx.data.repositories;

public interface LogDaoCustom {

	public void log(String message);

	void showLogs();

	void addSeparateLogsNotSupported();
	void addSeparateLogsSupports();
}
