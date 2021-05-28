package book_central.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.RestController;

//package book_central.controller;
@RestController

public class bookCRUDcontroller {
	
	private static final String URL = "jdbc:mysql://localhost:3306/book_central";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Cheeseistheanswer147";
    private static bookCRUDcontroller INSTANCE = new bookCRUDcontroller();
	private Connection connection;
	private bookCRUDcontroller() {
	}
	public static bookCRUDcontroller getInstance() {
		return INSTANCE;
	}
	public Connection getConnection() throws SQLException {
		INSTANCE.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		System.out.println("Connection Successful!");

		return connection;
	}
}
