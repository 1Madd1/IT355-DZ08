package com.metropolitan.it355dz08.service;

import com.metropolitan.it355dz08.entity.Author;
import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();

    Optional<Author> findByAuthorName(String authorName);
    List<Author> findByAuthorNameContainingIgnoreCase(String str);
    Integer countByAuthorNameEndingWith(String name);

    Optional<Author> findById(Integer id);

    Author save(Author author);

    Author update(Author author);

    void deleteById(Integer id);
}
