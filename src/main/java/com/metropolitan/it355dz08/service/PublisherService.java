package com.metropolitan.it355dz08.service;

import com.metropolitan.it355dz08.entity.Publisher;
import java.util.List;
import java.util.Optional;

public interface PublisherService {
    List<Publisher> findAll();

    List<Publisher> findByPublisherNameContainingIgnoreCase(String str);
    List<Publisher> findByPublisherNameStartingWith(String str);

    Optional<Publisher> findById(Integer id);

    Publisher save(Publisher publisher);

    Publisher update(Publisher publisher);

    void deleteById(Integer id);
}
