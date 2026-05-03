package com.springboot.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.domain.Book;
import com.springboot.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public List<Book> getAllBookList() {
		// TODO Auto-generated method stub
		return bookRepository.getAllBookList();
	}

	@Override
	public Book getBookById(String bookId) {
		// TODO Auto-generated method stub
		Book bookById = bookRepository.getBookById(bookId);
		return bookById;
	}

	@Override
	public List<Book> getBookListByCategory(String category) {
		// TODO Auto-generated method stub
		List<Book> booksByCategory = bookRepository.getBookListByCategory(category);
		return booksByCategory;
	}

	@Override
	public Set<Book> getBookListByFilter(Map<String, List<String>> filter) {
		// TODO Auto-generated method stub
		Set<Book> booksByFilter = bookRepository.getBookListByFilter(filter);
		return booksByFilter;
	}

}
