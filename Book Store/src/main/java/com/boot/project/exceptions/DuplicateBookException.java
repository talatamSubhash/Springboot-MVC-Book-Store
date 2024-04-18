package com.boot.project.exceptions;

import java.util.Optional;

import com.web.model.Book;

public class DuplicateBookException extends Exception {
	Book book;

	public DuplicateBookException(String msg) {
		super(msg);
	}

	public DuplicateBookException(Optional<Book> existingBook) {
		// TODO Auto-generated constructor stub
		book=existingBook.get();
	}
	public Book getBook() {
		return book;
	}

}
