package book_central.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import book_central.dao.BookSalesDao;
import book_central.entity.books;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultSalesService implements BooksSalesService {


@Autowired
private BookSalesDao bookSalesDao;
	@Override
	public List<books> fetchBooks(String title_id, String author_id) {
		log.info("The fetch books method was called with title_id={} and author_id={}",
				title_id, author_id);
		List<books> books = bookSalesDao.fetchBooks(title_id, author_id);
		
		if (books.isEmpty()) {
			String msg = String.format("no books found with title_id=%s and auhtor_id=%s", title_id, author_id);
			
			throw new NoSuchElementException(msg);
		}
		
//		Collections.sort((List<T>) books);
		return books;

		
	}

}

