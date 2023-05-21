package com.metropolitan.it355dz08.service.impl;

import com.metropolitan.it355dz08.entity.Book;
import com.metropolitan.it355dz08.repository.BookRepository;
import com.metropolitan.it355dz08.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public List<Book> findByNumPagesBetween(int min, int max) {
        return bookRepository.findByNumPagesBetween(min, max);
    }

    @Override
    public List<Book> findByLanguageIdAndNumPagesBetween(int id, int min, int max) {
        return bookRepository.findByLanguageIdAndNumPagesBetween(id, min, max);
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book update(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteById(Integer id) {
        bookRepository.deleteById(id);
    }
}
