package com.metropolitan.it355dz08.controller;


import com.metropolitan.it355dz08.entity.Book;
import com.metropolitan.it355dz08.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAll(){
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(bookService.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found!"))
        );
    }

    @GetMapping("/title")
    public ResponseEntity<Optional<Book>> findByTitle(@RequestParam String title){
        return ResponseEntity.ok(bookService.findByTitle(title));
    }

    @GetMapping("/numOfPages")
    public ResponseEntity<List<Book>> findByNumPagesBetween(@RequestParam int min, @RequestParam int max){
        return ResponseEntity.ok(bookService.findByNumPagesBetween(min, max));
    }

    @GetMapping("/languageAndNumOfPages")
    public ResponseEntity<List<Book>> findByLanguageIdAndNumPagesBetween(@RequestParam int id, @RequestParam int min, @RequestParam int max){
        return ResponseEntity.ok(bookService.findByLanguageIdAndNumPagesBetween(id, min, max));
    }

    @PostMapping
    public ResponseEntity<Book> save(@RequestBody Book book){
        return ResponseEntity.ok(bookService.save(book));
    }

    @PutMapping
    public ResponseEntity<Book> update(@RequestBody Book book){
        return ResponseEntity.ok(bookService.update(book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteById(@PathVariable Integer id){
        bookService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
