package book_central.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class create_order {
private String create_order_id;
private String order_id;
private String books_id;
}
