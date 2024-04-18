package com.web.controllerAdvice;



import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.boot.project.exceptions.DuplicateBookException;



@ControllerAdvice
public class BookControllerAdvice {
	@ExceptionHandler(value=DuplicateBookException.class)
	public String duplicateBookExceptionHandling(DuplicateBookException exception , Model model)
	{
    com.web.model.Book book=exception.getBook() ;
      model.addAttribute("book",book);
    model.addAttribute("message","Subhash handled duplicateBookException easily....");
  return "error-page";
	}
}
