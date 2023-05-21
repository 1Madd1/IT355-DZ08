package com.metropolitan.it355dz08.controller;

import com.metropolitan.it355dz08.entity.Publisher;
import com.metropolitan.it355dz08.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/publisher")
@RequiredArgsConstructor
public class PublisherController {

    private final PublisherService publisherService;

    @GetMapping
    public ResponseEntity<List<Publisher>> getAll(){
        return ResponseEntity.ok(publisherService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publisher> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(publisherService.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Publisher not found!"))
        );
    }

    @GetMapping("/name")
    public ResponseEntity<List<Publisher>> findByPublisherNameContainingIgnoreCase(@RequestParam String str){
        return ResponseEntity.ok(publisherService.findByPublisherNameContainingIgnoreCase(str));
    }

    @GetMapping("/name2")
    public ResponseEntity<List<Publisher>> findByPublisherNameStartingWith(@RequestParam String str){
        return ResponseEntity.ok(publisherService.findByPublisherNameStartingWith(str));
    }

    @PostMapping
    public ResponseEntity<Publisher> save(@RequestBody Publisher publisher){
        return ResponseEntity.ok(publisherService.save(publisher));
    }

    @PutMapping
    public ResponseEntity<Publisher> update(@RequestBody Publisher publisher){
        return ResponseEntity.ok(publisherService.update(publisher));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Publisher> deleteById(@PathVariable Integer id){
        publisherService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
