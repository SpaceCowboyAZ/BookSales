package book_central.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import book_central.controller.bookCRUDcontroller;
import book_central.entity.books;
@Service

public class booksCRUD {
	@Autowired

	public int createBook(String title_id, String author_id) throws SQLException {
		String sql = "INSERT INTO books (title_id, author_id) VALUES (?, ?)";
		Connection connection = null;
		PreparedStatement statement = null;
		int books_id = 0;
		
		try {
			connection = bookCRUDcontroller.getInstance().getConnection();
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, title_id);
			statement.setString(2, author_id);
			
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
			books_id = rs.getInt(1);	
			}
			}
		finally {
			if(statement != null) {
				statement.close();
			}
			if(connection != null) {
				connection.close();
			}
		}
		return books_id;
	}
	
	public List<books> fetchBooks() throws SQLException {
		String sql = "select * from books";
			//	+ "inner join author a on 
				
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		List<books> books = new ArrayList<>();
		
		try {
			connection = bookCRUDcontroller.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
		    rs = statement.executeQuery();
			
		    while(rs.next()) {
		    	String books_id = rs.getString("books_id");
		    	String title_id = rs.getString("title_id");
		    	String author_id = rs.getString("author_id");
		    	String isbn_id = rs.getString("isbn_id");
		    	books book = new books(books_id, title_id, author_id, isbn_id);
		    	books.add(book);
		    }
			return books;
			}
		finally {
			if(rs != null) {
				rs.close();
			}
			if(statement != null) {
				statement.close();
			}
			if(connection != null) {
				connection.close();
			}
		}
	}
	
	public void modifyBooks(String title_id, String author_id) throws SQLException {
		String sql = "UPDATE books SET title_id = ? WHERE title_id = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = bookCRUDcontroller.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, title_id);
			statement.setString(2, author_id);
			
			statement.executeUpdate();
			}
		finally {
			if(statement != null) {
				statement.close();
			}
			if(connection != null) {
				connection.close();
			}
		}
	}
	
	public void deleteBooks(String books_id) throws SQLException {
		String sql = "DELETE FROM books WHERE books_id = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = bookCRUDcontroller.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, books_id);
			
			statement.executeUpdate();
			}
		finally {
			if(statement != null) {
				statement.close();
			}
			if(connection != null) {
				connection.close();
			}
		}
	}
}



