package book_central.service;



import java.util.List;

import book_central.entity.books;


public interface BooksSalesService {
	
	/**
	   * Return a list of Jeeps given a model and trim level.
	   * @param model
	   * @param trim
	   * @return
	   */
	List<books> fetchBooks(String title_id, String author_id);
}