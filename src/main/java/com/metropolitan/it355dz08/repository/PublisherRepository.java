package com.metropolitan.it355dz08.repository;

import com.metropolitan.it355dz08.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
    List<Publisher> findByPublisherNameContainingIgnoreCase(String str);
    List<Publisher> findByPublisherNameStartingWith(String str);
}
