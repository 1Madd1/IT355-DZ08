package com.metropolitan.it355dz08.service.impl;

import com.metropolitan.it355dz08.entity.Author;
import com.metropolitan.it355dz08.repository.AuthorRepository;
import com.metropolitan.it355dz08.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findByAuthorName(String authorName) {
        return authorRepository.findByAuthorName(authorName);
    }

    @Override
    public List<Author> findByAuthorNameContainingIgnoreCase(String str) {
        return authorRepository.findByAuthorNameContainingIgnoreCase(str);
    }

    @Override
    public Integer countByAuthorNameEndingWith(String name) {
        return authorRepository.countByAuthorNameEndingWith(name);
    }

    @Override
    public Optional<Author> findById(Integer id) {
        return authorRepository.findById(id);
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author update(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void deleteById(Integer id) {
        authorRepository.deleteById(id);
    }
}
