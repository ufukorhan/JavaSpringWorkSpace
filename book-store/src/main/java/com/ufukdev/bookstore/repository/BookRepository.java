package com.ufukdev.bookstore.repository;


import com.ufukdev.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {}
