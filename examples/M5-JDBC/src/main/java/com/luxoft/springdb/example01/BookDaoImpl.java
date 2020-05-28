package com.luxoft.springdb.example01;

import static com.luxoft.springdb.example01.ConnectionManager.closeConnection;
import static com.luxoft.springdb.example01.ConnectionManager.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDaoImpl implements BookDao {

	@Override
	public void printAll() {
		String sql = "SELECT * FROM BOOK";

		PreparedStatement statement;

		try {
			Connection connection = openConnection();
			statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			if (!resultSet.isBeforeFirst()) {
				System.out.println("Empty book list");
				return;
			}
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getDate(3));
			}

			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	@Override
	public void insert(Book book) {
		String sql = "INSERT INTO BOOK (TITLE, DATE_RELEASE) VALUES (?, ?)";
		PreparedStatement statement;

		try {
			Connection connection = openConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, book.getTitle());
			statement.setDate(2, new java.sql.Date(book.getDateRelease().getTime()));
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

	}

	@Override
	public void update(int id, String title) {
		String sql = "UPDATE BOOK SET TITLE = ? WHERE ID = ?";
		PreparedStatement statement;

		try {
			Connection connection = openConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, title);
			statement.setInt(2, id);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	@Override
	public void delete(Book book) {
		String sql = "DELETE FROM BOOK WHERE TITLE = ?";
		PreparedStatement statement;

		try {
			Connection connection = openConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, book.getTitle());
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

	}

	@Override
	public Book getById(int id) {

		String sql = "SELECT * FROM BOOK WHERE ID = ?";

		PreparedStatement statement;
		Book book = null;

		try {
			Connection connection = openConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				book = new Book();
				book.setId(resultSet.getInt(1));
				book.setTitle(resultSet.getString(2));
				book.setDateRelease(resultSet.getDate(3));
			}

			statement.close();
			System.out.println();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return book;

	}

}
