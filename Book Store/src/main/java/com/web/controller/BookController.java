package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.RedirectAttributesMethodArgumentResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.boot.project.exceptions.DuplicateBookException;
import com.web.model.Book;
import com.web.service.BookService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/books")
public class BookController {
	@Autowired
	BookService bookService;
	@GetMapping("/viewBooks")
	 public String getAllBooks(Model model) {
	List<Book>books=bookService.getbooks()	;
	model.addAttribute("books",books);
	 return "view-books";
			 }
	@GetMapping("/addbook")
	public String addBookPage() {
		return "add-book";
	}
	@PostMapping("/savebook")
	public String saveBook(@Valid @ModelAttribute Book book,BindingResult bindingResult ,Model model,RedirectAttributes redirectAttributes) throws DuplicateBookException {
		if(bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult);
			return "add-book";
		}
		boolean status=bookService.savebookData(book);
		if(status) {
			//redirectAttributes.addFlashAttribute("savemessage","Data saved Successfully.....");
			redirectAttributes.addFlashAttribute("savemessage",true);
		}
		return "redirect:/books/viewBooks";
	}
	@GetMapping("/delete/{isbn}")
	public String deleteBook(@PathVariable Integer isbn,RedirectAttributes redirectAttributes) {
		boolean status=bookService.deleteBookData(isbn);
		if(status) {
			redirectAttributes.addFlashAttribute("deletemessage",true);
		}
		return "redirect:/books/viewBooks";
	}
	@GetMapping("/edit/{isbn}")
	public String editBook(@PathVariable Integer isbn,Model model) {
		Book book= bookService.editBook(isbn);
		//model.addAttribute("book", book);
		model.addAttribute("book", book);
		return "edit-form";
	}
	@PostMapping("/editsavebook")
	public String saveEditBook(@ModelAttribute Book editbook) {
		bookService.editBookSave(editbook);
		
		return "redirect:/books/viewBooks";
	}

}
