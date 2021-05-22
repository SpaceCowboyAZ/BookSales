package book_central.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import book_central.entity.author;
import book_central.entity.books;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/books")
@OpenAPIDefinition(info = @Info(title = "book sales service"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server.")})
public interface BookSalesController {
	
	

//	@Operation(
//			summary = "Returns a list of books",
//			description = "Returns a list of books given an optional we or trim",
//			responses = {
//					@ApiResponse(responseCode = "200", description ="A list of books returned", 
//							content = @Content(mediaType = "application/json", schema = @Schema(implementation = books.class))),
//					@ApiResponse(responseCode = "400", description = "The request parameters are invalid",
//							content = @Content(mediaType = "application/json")),
//					@ApiResponse(responseCode = "404", description = "No books were found with inputs",
//							content = @Content(mediaType = "application/json")),
//					@ApiResponse(responseCode = "500", description = "Error occured",
//							content = @Content(mediaType = "application/json"))},
//			parameters = {
//					@Parameter(name = "book title", allowEmptyValue = false, required = false,
//							description = "The book title (i.e., 'It')"),
//					@Parameter(name = "author", allowEmptyValue = false, required = false, description = "Author (i.e. 'Stephen King'")
//			}
//)
@GetMapping	
@ResponseStatus(code = HttpStatus.OK)
List<books> fetchBooks(
	@RequestParam(required = false) 
	String title_id, String author_id);



	
}
