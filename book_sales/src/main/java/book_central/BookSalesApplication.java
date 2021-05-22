package book_central;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = { ComponentScanMarker.class })
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
public class BookSalesApplication {


	public static void main(String[] args) {
		SpringApplication.run(BookSalesApplication.class, args);
	}

}
