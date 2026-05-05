package com.springboot.domain;

import java.math.BigDecimal;
import org.springframework.web.multipart.MultipartFile;
import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class Book {
	@Pattern(regexp="ISBN[1-9]+")
	private String bookId;
	
	@Size(min=4, max=50)
	private String name;
	
	@Min(value=0)
	@Digits(integer=8, fraction=2)
	@NotNull
	private BigDecimal unitPrice;
	private String author;
	private String description;
	private String publisher;
	private String category;
	private long unitsInStock;
	private String releaseDate;
	private String condition;
	private String fileName;
	private MultipartFile bookImage;
}
