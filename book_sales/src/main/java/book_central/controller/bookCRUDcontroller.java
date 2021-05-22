package book_central.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import book_central.entity.books;
import book_central.service.DefaultSalesService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("books")
public class bookCRUDcontroller {
private final DefaultSalesService service;

public bookCRUDcontroller(DefaultSalesService service) {
	this.service = service;
}

@GetMapping
public ResponseEntity<List<books>> findAll() {
	List<books> books = service.findAll();
	return ResponseEntity.ok().body(books);
}
@GetMapping("/{books_id}")
public ResponseEntity<books> find(@PathVariable("books_id") String books_id) {
    java.util.Optional<books> item = service.find(books_id);
    return ResponseEntity.of(item);
}
@PostMapping
public ResponseEntity<books> create(@RequestBody books book) {
    books created = service.create(book);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{books_id}")
            .buildAndExpand(created.getBooks_id())
            .toUri();
    return ResponseEntity.created(location).body(created);
}
@PutMapping("/{books_id}")
public ResponseEntity<books> update(
        @PathVariable("books_id") String books_id,
        @RequestBody books updatedBook) {

    Optional<books> updated = service.update(books_id, updatedBook);

    return updated
            .map(value -> ResponseEntity.ok().body(value))
            .orElseGet(() -> {
                books created = service.create(updatedBook);
                URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{books_id}")
                        .buildAndExpand(created.getBooks_id())
                        .toUri();
                return ResponseEntity.created(location).body(created);
            });
}

@DeleteMapping("/{books_id}")
public ResponseEntity<books> delete(@PathVariable("id") String books_id) {
    service.delete(books_id);
    return ResponseEntity.noContent().build();
}
}
