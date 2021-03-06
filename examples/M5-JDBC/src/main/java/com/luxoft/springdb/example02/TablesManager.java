package com.luxoft.springdb.example02;

import static com.luxoft.springdb.example01.ConnectionManager.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TablesManager {
	
    public static void createTable() {
    	String sql = "CREATE TABLE IF NOT EXISTS BOOK (ID INTEGER generated by default as identity (start with 1), " +
    			     "TITLE VARCHAR(50), " +
    			     "DATE_RELEASE TIMESTAMP);";
    	
    	executeStatement(sql);
    }

    public static void dropTable() {
    	String sql = "DROP TABLE IF EXISTS BOOK;";
    	
    	executeStatement(sql);
    }
    
    private static void executeStatement(String sql) {
		PreparedStatement statement;
    	
    	try {
            Connection connection = openConnection();
            statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            statement.close();
       } catch (SQLException e) {
            e.printStackTrace();
       } finally {
            closeConnection();
       }
	}

}
