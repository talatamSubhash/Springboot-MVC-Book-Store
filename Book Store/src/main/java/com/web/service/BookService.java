package com.web.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.boot.project.exceptions.DuplicateBookException;
import com.web.model.Book;
@Service
public class BookService {

	public static List<Book> books=new ArrayList<Book>();
	static {
		books.add(new Book(1001,"Spring","Mr.ratan"));
		books.add(new Book(1002,"SpringBoot","t.subhash"));
		books.add(new Book(1003,"MicroServices","sathya"));
		
	}
	public List<Book>getbooks(){
		return books;
		
	}
	public boolean savebookData(Book book) throws DuplicateBookException {
		
		Optional<Book> existingBook=books.stream()
		.filter(b->b.getIsbn().equals(book.getIsbn()))
		.findFirst();
	
		if(existingBook.isPresent()) {
			throw new DuplicateBookException(existingBook);
			
		}
		
		return books.add(book);
		
	}
	public boolean deleteBookData(Integer isbn) {
	Book book=	books.stream()
		.filter(b->b.getIsbn().equals(isbn))
		.findFirst()
		.get();
		return books.remove(book);
		
	}
	public Book editBook(Integer isbn) {
		Book book=	books.stream()
				.filter(b->b.getIsbn().equals(isbn))
				.findFirst()
				.get();
		return book;
	}
	public Book editBookSave(Book editbook) {
		Book book=books.stream()
				.filter(b->b.getIsbn().equals(editbook.getIsbn()))
				.findFirst()
				.get();
		if(book!=null) {
			book.setName(editbook.getName());
			book.setAuthor(editbook.getAuthor());
			
		}
		return book;
	}
	
		
	}

