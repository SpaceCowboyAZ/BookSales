//package book_central.service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Service;
//
//
//
//@Service
//@EnableJdbcRepositories
//public class booksService {
//
//	  private final CrudRepository<book_central.entity.books, String> repository;
//	  
//	  public booksService(CrudRepository<book_central.entity.books, String> repository) {
//		    this.repository = repository;
//
//		    this.repository.saveAll(books());
//}
//	  
//	  private static List<book_central.entity.books> books() {
//		  return List.of(
//				  new book_central.entity.books("a", "It", "Steven King")
//				  
//				  );
//		  
//				  
//	  }
//	  public List<book_central.entity.books> findAll() {
//		  List<book_central.entity.books> list = new ArrayList<>();
//		  Iterable<book_central.entity.books> books =repository.findAll();
//		  books.forEach(list::add);
//		  return list;
//	  }
//	  
//	  public Optional<book_central.entity.books> find(String book_id) {
//		  return repository.findById(book_id);
//	  }
//	  
//	  public book_central.entity.books create(book_central.entity.books book) {
//		  book_central.entity.books copy = new book_central.entity.books(
//				  book.getBook_id(),
//				  book.getTitle_id(),
//				  book.getAuthor_id()
//				  );
//		  return repository.save(copy);
//
//	  }
//
//	public Optional<book_central.entity.books> update(String book_id, book_central.entity.books newBook) {
//		  
//	 return repository.findById(book_id)
//					  .map(oldBook -> {
//						  book_central.entity.books updated = oldBook.updateWith(newBook);
//						  return repository.save(updated);
//					  });
//	  }
//	
//	public void delete(String book_id) {
//		repository.deleteById(book_id);
//	}
//}
