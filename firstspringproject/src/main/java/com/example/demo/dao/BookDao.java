package com.example.demo.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Book;


public interface BookDao extends JpaRepository<Book,Integer>{
	public Book findById(int id);
}
