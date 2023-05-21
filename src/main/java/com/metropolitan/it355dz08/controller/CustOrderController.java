package com.metropolitan.it355dz08.controller;

import com.metropolitan.it355dz08.entity.CustOrder;
import com.metropolitan.it355dz08.service.CustOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Controller
@RequestMapping("/custOrder")
@RequiredArgsConstructor
public class CustOrderController {

    private final CustOrderService custOrderService;

    @GetMapping
    public ResponseEntity<List<CustOrder>> getAll(){
        return ResponseEntity.ok(custOrderService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustOrder> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(custOrderService.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "CustOrder not found!"))
        );
    }

    @GetMapping("/date")
    public ResponseEntity<List<CustOrder>> findByOrderDateBetween(@RequestParam String beginningDate, String endingDate){
        return ResponseEntity.ok(custOrderService.findByOrderDateBetween(beginningDate, endingDate));
    }

    @GetMapping("/email")
    public ResponseEntity<List<CustOrder>> findByCustomerEmailContainingIgnoreCase(@RequestParam String email){
        return ResponseEntity.ok(custOrderService.findByCustomerEmailContainingIgnoreCase(email));
    }

    @PostMapping
    public ResponseEntity<CustOrder> save(@RequestBody CustOrder custOrder){
        return ResponseEntity.ok(custOrderService.save(custOrder));
    }

    @PutMapping
    public ResponseEntity<CustOrder> update(@RequestBody CustOrder custOrder){
        return ResponseEntity.ok(custOrderService.update(custOrder));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustOrder> deleteById(@PathVariable Integer id){
        custOrderService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
