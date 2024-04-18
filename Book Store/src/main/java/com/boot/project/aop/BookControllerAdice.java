package com.boot.project.aop;

import org.springframework.boot.Banner.Mode;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.boot.project.exceptions.DuplicateBookException;
import com.web.model.Book;

@ControllerAdvice
public class BookControllerAdice {
	@ExceptionHandler(value=DuplicateBookException.class)
public String duplicateBookExceptionHandling(DuplicateBookException exception,Model model) {
Book book=exception.getBook();
model.addAttribute("book",book);
model.addAttribute("message","Ratan sir handled DuplicateBookException easily....");
return "error-page";
	}
}

