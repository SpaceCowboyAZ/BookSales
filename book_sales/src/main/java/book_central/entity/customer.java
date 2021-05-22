package book_central.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class customer {
private String customer_id;
private String first_name_id;
private String last_name_id;
private String email;
private String address;
private String phone_number;
}
