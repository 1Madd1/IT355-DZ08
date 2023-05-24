package com.metropolitan.it355dz08.controller;

import com.metropolitan.it355dz08.entity.Book;
import com.metropolitan.it355dz08.entity.BookLanguage;
import com.metropolitan.it355dz08.entity.Publisher;
import com.metropolitan.it355dz08.repository.BookRepository;
import com.metropolitan.it355dz08.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
class BookControllerTest {

    @Autowired
    BookService bookService;

    @MockBean
    private BookRepository bookRepository;

    @Test
    void getAll() {
        BookLanguage bookLanguage1 = new BookLanguage(1, "en", "English");
        BookLanguage bookLanguage2 = new BookLanguage(2, "sr", "Serbian");
        BookLanguage bookLanguage3 = new BookLanguage(3, "sp", "Spanish");
        Publisher publisher1 = new Publisher(1,"BookPublisher1");
        Publisher publisher2 = new Publisher(2,"BookPublisher2");
        Publisher publisher3 = new Publisher(3,"BookPublisher3");
        LocalDate date = LocalDate.now();
        Book book1 = new Book(1,"Gusari oko podne", "34406100602", bookLanguage2, 100, date, publisher1);
        Book book2 = new Book(2,"Humming Bird", "30172940572", bookLanguage1, 380, date, publisher2);
        Book book3 = new Book(3,"El alquimista", "91037162530", bookLanguage3, 500, date, publisher3);
        Book book4 = new Book(4,"Balkanski Spijun", "71029385729", bookLanguage1, 490, date, publisher2);
        Book book5 = new Book(5,"Pop Cira i pop Spira", "19283000271", bookLanguage1, 330, date, publisher1);
        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        bookList.add(book5);
        when(bookRepository.findAll()).thenReturn(bookList);
        Integer expectedCount = 5;

        Assertions.assertEquals(expectedCount, bookService.findAll().size());
        Assertions.assertTrue(bookService.findAll().contains(book5));
    }

    @Test
    void getById() {
        BookLanguage bookLanguage1 = new BookLanguage(1, "sr", "Serbian");
        Publisher publisher1 = new Publisher(1,"BookPublisher1");
        LocalDate date = LocalDate.now();
        Optional<Book> book1 = Optional.of(new Book(1, "Gusari oko podne", "34406100602", bookLanguage1, 100, date, publisher1));
        when(bookRepository.findById(1)).thenReturn(book1);
        Assertions.assertEquals(book1, bookService.findById(1));
    }

    @Test
    void findByTitle() {
        BookLanguage bookLanguage1 = new BookLanguage(1, "sr", "Serbian");
        Publisher publisher1 = new Publisher(1,"BookPublisher1");
        LocalDate date = LocalDate.now();
        Optional<Book> book1 = Optional.of(new Book(1, "Gusari oko podne", "34406100602", bookLanguage1, 100, date, publisher1));
        when(bookRepository.findByTitle("Gusari oko podne")).thenReturn(book1);

        Assertions.assertEquals(book1, bookService.findByTitle("Gusari oko podne"));
    }

    @Test
    void save() {
        BookLanguage bookLanguage1 = new BookLanguage(1, "sr", "Serbian");
        Publisher publisher1 = new Publisher(1,"BookPublisher1");
        LocalDate date = LocalDate.now();
        Book book1 = new Book(1, "Gusari oko podne", "34406100602", bookLanguage1, 100, date, publisher1);
        when(bookRepository.save(book1)).thenReturn(book1);

        Assertions.assertEquals(book1, bookService.save(book1));
    }

    @Test
    void update() {
        BookLanguage bookLanguage1 = new BookLanguage(1, "en", "English");
        BookLanguage bookLanguage2 = new BookLanguage(2, "sr", "Serbian");
        Publisher publisher1 = new Publisher(1,"BookPublisher1");
        Publisher publisher2 = new Publisher(2,"BookPublisher2");
        LocalDate date = LocalDate.now();
        Book book1 = new Book(1,"Gusari oko podne", "34406100602", bookLanguage2, 100, date, publisher1);
        Book book2 = new Book(1,"Humming Bird", "30172940572", bookLanguage1, 380, date, publisher2);

        when(bookRepository.save(book1)).thenReturn(book1);
        when(bookRepository.save(book2)).thenReturn(book2);

        Assertions.assertEquals(book2, bookService.save(book2));
    }

    @Test
    void deleteById() {
        BookLanguage bookLanguage1 = new BookLanguage(1, "sr", "Serbian");
        Publisher publisher1 = new Publisher(1,"BookPublisher1");
        LocalDate date = LocalDate.now();
        Book book1 = new Book(1, "Gusari oko podne", "34406100602", bookLanguage1, 100, date, publisher1);
        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        when(bookRepository.findAll()).thenReturn(bookList);

        bookRepository.deleteById(1);
        bookList.remove(book1);
        Integer expectedCount = 0;

        Assertions.assertEquals(expectedCount, bookService.findAll().size());
    }
}