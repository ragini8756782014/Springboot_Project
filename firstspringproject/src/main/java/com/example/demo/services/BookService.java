package com.example.demo.services;
import java.util.List;
//import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.BookDao;
import com.example.demo.entity.Book;





@Component
public class BookService {

	
	@Autowired
	private BookDao bookDao;
//	 private static List<Book> list=new ArrayList();
//	 
//	static {
//		
//		list.add(new Book(12,"java","zxc"));
//		list.add(new Book (13,"python","asd"));
//		list.add(new Book (14,"c++","uio"));
//		list.add(new Book (15,"javascript","tyu"));
//	}
	
	
	public List<Book> getAllBook()
	{
		return bookDao.findAll();
	}
	
	public Book getBookById(int id)
	{
//	Book book= list.stream().filter(e->e.getId()==id).findFirst().get();
	   return bookDao.findById(id);
	
	}
	
	public Book addBook(Book b)
	{
//		list.add(b);
		bookDao.save(b);
		return b;
	}
	
	public void deleteBook(int id)
	{
//		list=list.stream().filter(e->(e.getId()!=id)).collect(Collectors.toList());
		bookDao.deleteById(id);
	}
	
	
	public void updateBook(Book book,int id)
	{
//		list=list.stream().map(b->{
//		if(b.getId()==id){
//			b.setAuthor(book.getAuthor());
//			b.setTitle(book.getTitle());
//		}
//		return b;	
//		}).collect(Collectors.toList());
		bookDao.save(book);
	}
	
	
	
	
	
}
