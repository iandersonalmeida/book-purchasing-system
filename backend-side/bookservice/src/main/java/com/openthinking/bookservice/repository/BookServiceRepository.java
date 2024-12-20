package com.openthinking.bookservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.openthinking.bookservice.domain.Book;

@Repository
public interface BookServiceRepository extends JpaRepository<Book, Integer> {
	//@Query("select b from Book b where b.author = ?1")
	public List<Book> findByAuthor(String author);
	
	@Query("select b from Book b")
	public List<Book> findAllBooks();
	
}
