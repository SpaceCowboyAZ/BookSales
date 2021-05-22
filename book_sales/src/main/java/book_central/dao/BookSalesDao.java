package book_central.dao;

import java.util.List;

import book_central.entity.books;

public interface BookSalesDao {

	List<books> fetchBooks(String title_id, String author_id);

}
