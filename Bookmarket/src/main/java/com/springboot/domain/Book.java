package com.springboot.domain;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Book {
	private String bookId;
	private String name;
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
