package com.metropolitan.it355dz08.service;

import com.metropolitan.it355dz08.entity.CustOrder;
import com.metropolitan.it355dz08.entity.Publisher;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface CustOrderService {
    List<CustOrder> findAll();

    List<CustOrder> findByOrderDateBetween(String beginningDate, String endingDate);
    List<CustOrder> findByCustomerEmailContainingIgnoreCase(String email);

    Optional<CustOrder> findById(Integer id);

    CustOrder save(CustOrder custOrder);

    CustOrder update(CustOrder custOrder);

    void deleteById(Integer id);
}
