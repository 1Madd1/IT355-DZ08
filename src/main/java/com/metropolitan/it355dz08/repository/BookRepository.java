package com.metropolitan.it355dz08.repository;

import com.metropolitan.it355dz08.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> findByTitle(String title);

    List<Book> findByNumPagesBetween(int min, int max);
    List<Book> findByLanguageIdAndNumPagesBetween(int id, int min, int max);
}
