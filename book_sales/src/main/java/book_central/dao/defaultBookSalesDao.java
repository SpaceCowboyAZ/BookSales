package book_central.dao;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import book_central.entity.books;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class defaultBookSalesDao implements BookSalesDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public List<books> fetchBooks(String title_id, String author_id) {
		log.debug("DAO: title_id= {}, author_id= {}", title_id, author_id);
		
		String sql = ""
				+ "SELECT *"
				+ "FROM books "
				+ "WHERE title_id = :title_id AND author_id = :author_id";
		
		Map<String, Object> params = new HashMap<>();
		params.put("title_id", title_id);
		params.put("author_id", author_id);
		
		return jdbcTemplate.query(sql, params,
				new RowMapper<>() {

					@Override
					public books mapRow(ResultSet rs, int rowNum) throws SQLException {
						
						return books.builder()
								
								.title_id(rs.getString("title_id"))
								.author_id(rs.getString("author_id"))
								.isbn_id(rs.getString("isbn_id"))
								.books_id(rs.getString("books_id"))
								
								.build();
					}});
	}
		
			
	}


