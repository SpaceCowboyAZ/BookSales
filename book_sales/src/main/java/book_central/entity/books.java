package book_central.entity;




import org.springframework.data.annotation.Id;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class books {

	private String books_id;
	private String title_id;
	private String author_id;

	public books(
			String books_id,
			String title_id,
			String author_id
			) {

	this.books_id = books_id;
	this.title_id = title_id;
	this.author_id = author_id;
	}
	@Id
	public String getBook_id() {
	return books_id;
	}

	public String getTitle_id() {
		return title_id;
	}

	public String getAuthor_id() {
		return author_id;
	}


	public books updateWith(books books) {
		
		return new books(
				this.books_id,
				this.title_id,
				this.author_id);

	}
}
	

