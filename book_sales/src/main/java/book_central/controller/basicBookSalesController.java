package book_central.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import book_central.entity.books;
import book_central.service.BooksSalesService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class basicBookSalesController implements BookSalesController {

	
	@Autowired
	private BooksSalesService booksalesService;
	
	

	@Override
	public List<books> fetchBooks(String title_id, String author_id) {
		log.debug("books_id={}, author_id={}", title_id, author_id);
		return booksalesService.fetchBooks(title_id, author_id);
	}



	
	}


