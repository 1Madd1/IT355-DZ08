package com.metropolitan.it355dz08.service.impl;

import com.metropolitan.it355dz08.entity.Publisher;
import com.metropolitan.it355dz08.repository.PublisherRepository;
import com.metropolitan.it355dz08.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;

    @Override
    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    @Override
    public List<Publisher> findByPublisherNameContainingIgnoreCase(String str) {
        return publisherRepository.findByPublisherNameContainingIgnoreCase(str);
    }

    @Override
    public List<Publisher> findByPublisherNameStartingWith(String str) {
        return publisherRepository.findByPublisherNameStartingWith(str);
    }

    @Override
    public Optional<Publisher> findById(Integer id) {
        return publisherRepository.findById(id);
    }

    @Override
    public Publisher save(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public Publisher update(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public void deleteById(Integer id) {
        publisherRepository.deleteById(id);
    }
}
