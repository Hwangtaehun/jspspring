package com.springboot.domain;

import java.math.BigDecimal;
import org.springframework.web.multipart.MultipartFile;
import lombok.Data;
import jakarta.validation.constraints.*;
import com.springboot.validator.BookId;

@Data
public class Book {
	@BookId
	@Pattern(regexp="ISBN[1-9]+",message="{Pattern.book.bookId}")
	private String bookId;
	
	@Size(min=4, max=50, message="{Size.book.name}")
	private String name;
	
	@Min(value=0, message="{Min.book.unitPrice}")
	@Digits(integer=8, fraction=2, message="{Digits.book.unitPrice}")
	@NotNull(message="{NotNull.book.unitPrice}")
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
