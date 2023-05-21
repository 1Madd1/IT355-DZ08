package com.metropolitan.it355dz08.service.impl;

import com.metropolitan.it355dz08.entity.CustOrder;
import com.metropolitan.it355dz08.entity.Publisher;
import com.metropolitan.it355dz08.repository.CustOrderRepository;
import com.metropolitan.it355dz08.service.CustOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustOrderServiceImpl implements CustOrderService {

    private final CustOrderRepository custOrderRepository;

    @Override
    public List<CustOrder> findAll() {
        return custOrderRepository.findAll();
    }

    @Override
    public List<CustOrder> findByOrderDateBetween(String beginningDate, String endingDate) {
        Date myDate1 = null;
        Date myDate2 = null;
        try {
            myDate1 = new SimpleDateFormat("yyyy-MM-dd").parse(beginningDate);
            myDate2 = new SimpleDateFormat("yyyy-MM-dd").parse(endingDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return custOrderRepository.findByOrderDateBetween(myDate1.toInstant(), myDate2.toInstant());
    }

    @Override
    public List<CustOrder> findByCustomerEmailContainingIgnoreCase(String email) {
        return custOrderRepository.findByCustomerEmailContainingIgnoreCase(email);
    }

    @Override
    public Optional<CustOrder> findById(Integer id) {
        return custOrderRepository.findById(id);
    }

    @Override
    public CustOrder save(CustOrder custOrder) {
        return custOrderRepository.save(custOrder);
    }

    @Override
    public CustOrder update(CustOrder custOrder) {
        return custOrderRepository.save(custOrder);
    }

    @Override
    public void deleteById(Integer id) {
        custOrderRepository.deleteById(id);
    }
}
