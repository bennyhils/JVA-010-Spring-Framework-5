package com.luxoft.springdb.example08;

import java.sql.SQLException;

import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;

public class CustomSQLErrorCodesTranslator extends SQLErrorCodeSQLExceptionTranslator {
	
	protected CustomException customTranslate(String task, String sql, SQLException sqlex) {
        if (sqlex.getErrorCode() == 42001) {
            return new CustomException(task, sql, sqlex);
        }
        return null;
    }
}
