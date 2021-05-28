package book_central.entity;




import java.util.Comparator;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class books {

	private String books_id;
	private String title_id;
	private String author_id;
	private String isbn_id;
//	private String customer_id;
	public int compareTo(books that) {
		
		return Comparator
				.comparing(books::getAuthor_id)
				.thenComparing(books::getTitle_id)
				.compare(this, that);
	}

	public books(String books_id, String title_id, String author_id, String isbn_id) {
    	this.books_id = books_id;
    	this.title_id = title_id;
    	this.author_id = author_id;
    	this.isbn_id = isbn_id;
    }

	public String getTitle() {
		return title_id;
	}

	public String getAuthorId() {
		return author_id;
	}
	

		}	