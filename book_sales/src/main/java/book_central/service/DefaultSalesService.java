package book_central.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import book_central.dao.BookSalesDao;
import book_central.entity.books;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultSalesService implements BooksSalesService {


@Autowired
private BookSalesDao bookSalesDao;
private final CrudRepository<book_central.entity.books, String> repository;

public DefaultSalesService(CrudRepository<books, String> repository) {
	    this.repository = repository;

	    this.repository.saveAll(books());
}

private static List<books> books() {
	  return List.of(
			  new book_central.entity.books("a", "It", "Steven King")
			  
			  );
	  
			  
}
public List<books> findAll() {
	  List<books> list = new ArrayList<>();
	  Iterable<books> books =repository.findAll();
	  books.forEach(list::add);
	  return list;
}

public Optional<books> find(String books_id) {
	  return repository.findById(books_id);
}

public books create(books book) {
	  books copy = new books(
			  book.getBooks_id(),
			  book.getTitle_id(),
			  book.getAuthor_id()
			  );
	  return repository.save(copy);

}

public Optional<books> update(String books_id, books newBook) {
	  
return repository.findById(books_id)
				  .map(oldBook -> {
					  books updated = oldBook.updateWith(newBook);
					  return repository.save(updated);
				  });
}

public void delete(String books_id) {
	repository.deleteById(books_id);
}

	@Override
	public List<books> fetchBooks(String title_id, String author_id) {
		log.info("The fetch books method was called with title_id={} and author_id={}",
				title_id, author_id);
		List<books> books = bookSalesDao.fetchBooks(title_id, author_id);
		
		if (books.isEmpty()) {
			String msg = String.format("no books found with title_id=%s and auhtor_id=%s", title_id, author_id);
			
			throw new NoSuchElementException(msg);
		}
		
		Collections.sort(books);
		return books;

		
	}

}
