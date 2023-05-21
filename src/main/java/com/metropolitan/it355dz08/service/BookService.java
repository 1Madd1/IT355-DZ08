package com.metropolitan.it355dz08.service;


import com.metropolitan.it355dz08.entity.Book;
import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();

    Optional<Book> findByTitle(String title);

    List<Book> findByNumPagesBetween(int min, int max);

    List<Book> findByLanguageIdAndNumPagesBetween(int id, int min, int max);

    Optional<Book> findById(Integer id);

    Book save(Book book);

    Book update(Book book);

    void deleteById(Integer id);
}
