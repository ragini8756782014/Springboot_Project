package com.example.demo;



import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.BookDao;
import com.example.demo.entity.Book;
import com.example.demo.services.BookService;

@RunWith(SpringRunner.class)
@SpringBootTest
 public class FirstspringprojectApplicationTests {

	 @Autowired
		private BookService service;
		
		@MockBean
		private BookDao repository;
		
		@Test
		public void getAllBookTest() {
			when(repository.findAll()).thenReturn(Stream
					.of(new Book(1,"java","zxc"),new Book(13,"django","hyu")).collect(Collectors.toList()));
			assertEquals(2,service.getAllBook().size());
		}
		
		
		@Test
		public void addBookTest() {
			Book book=new Book(3,"ragini","wer");
			when(repository.save(book)).thenReturn(book);
			assertEquals(book,service.addBook(book));
		}
		
		
		@Test 
		public void deleteBookTest() {
			Book book=new Book(333,"rajhkjni","wjkr");
			service.deleteBook(333);
		verify(repository,times(1)).deleteById(333);	
		}
		
		
		@Test
		public void getBookByIdTest() {
			Book book=new Book(333,"rajhkjni","wjkr");
			when(repository.findById(333)).thenReturn(book);
			
			assertThat(service.getBookById(333)).isEqualTo(book);
		}
 
}
