package com.metropolitan.it355dz08.controller;

import com.metropolitan.it355dz08.entity.Author;
import com.metropolitan.it355dz08.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<Author>> getAll(){
        return ResponseEntity.ok(authorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(authorService.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found!"))
        );
    }

    @GetMapping("/name")
    public ResponseEntity<Optional<Author>> findByAuthorName(@RequestParam String name){
        return ResponseEntity.ok(authorService.findByAuthorName(name));
    }

    @GetMapping("/name2")
    public ResponseEntity<List<Author>> findByAuthorNameContainingIgnoreCase(@RequestParam String name){
        return ResponseEntity.ok(authorService.findByAuthorNameContainingIgnoreCase(name));
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> countByAuthorNameEndingWith(@RequestParam String name){
        return ResponseEntity.ok(authorService.countByAuthorNameEndingWith(name));
    }

    @PostMapping
    public ResponseEntity<Author> save(@RequestBody Author author){
        return ResponseEntity.ok(authorService.save(author));
    }

    @PutMapping
    public ResponseEntity<Author> update(@RequestBody Author author){
        return ResponseEntity.ok(authorService.update(author));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Author> deleteById(@PathVariable Integer id){
        authorService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
