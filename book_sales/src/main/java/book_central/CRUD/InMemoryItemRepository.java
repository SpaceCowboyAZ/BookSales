package book_central.CRUD;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import book_central.entity.books;

@Repository
public interface InMemoryItemRepository extends CrudRepository<books, String> {

}
