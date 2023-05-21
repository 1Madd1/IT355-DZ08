package com.metropolitan.it355dz08.repository;

import com.metropolitan.it355dz08.entity.CustOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.Instant;
import java.util.List;

public interface CustOrderRepository extends JpaRepository<CustOrder, Integer> {
    List<CustOrder> findByOrderDateBetween(Instant beginningDate, Instant endingDate);
    List<CustOrder> findByCustomerEmailContainingIgnoreCase(String email);
}
