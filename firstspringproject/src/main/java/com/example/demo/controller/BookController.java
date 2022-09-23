package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.services.BookService;


@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	 
	private static final org.slf4j.Logger logger =LoggerFactory.getLogger(BookController.class);
	
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBook()
	{	
		List<Book> list=bookService.getAllBook();
		try
		{   logger.info("getting list of all books");
			return  ResponseEntity.of(Optional.of(list));
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("something gone wrong ");
		    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") int id)
	{  Book book=null;
		try
	     {
			logger.info("getting book of a perticular id");
			book=this.bookService.getBookById(id);
		return ResponseEntity.of(Optional.of(book));
				
	     }catch(Exception e)
          {
	    	 logger.error("something gone wrong");
		     return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
           }
	}
	
	
	
	@PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book b=null;
		try {
			logger.info("adding a book");
			b=this.bookService.addBook(book);
			return ResponseEntity.of(Optional.of(b));
		}catch(Exception e)
		{    logger.error("something gone wrong");
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		
	}
	
	
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable("id") int id)
	{    try {
		logger.info("deleting a book");
		this.bookService.deleteBook(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}catch(Exception e) {
		e.printStackTrace();
		 logger.error("something gone wrong");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}   
	}
	
	
	
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("id") int id)
	{try {
		logger.info("updating a existing book by id");
		this.bookService.updateBook(book,id);
		return ResponseEntity.ok().body(book);
	}catch(Exception e) {
		e.printStackTrace();
		 logger.error("something gone wrong");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
		
	}
	
}
