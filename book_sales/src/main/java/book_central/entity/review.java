package book_central.entity;



import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class review {
	private String review_id;     
	 private String customer_id;  
	private String order_book_id; 
	private String books_id;
}
