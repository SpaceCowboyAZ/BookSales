package book_central.entity;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class order_details {
	private String order_id;    
	private String customer_id;    
	private String order_date;                
	private String ship_date;
	

}
