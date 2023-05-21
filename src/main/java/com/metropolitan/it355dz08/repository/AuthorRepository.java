package com.metropolitan.it355dz08.repository;

import com.metropolitan.it355dz08.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    Optional<Author> findByAuthorName(String authorName);
    List<Author> findByAuthorNameContainingIgnoreCase(String str);
    Integer countByAuthorNameEndingWith(String name);
}
