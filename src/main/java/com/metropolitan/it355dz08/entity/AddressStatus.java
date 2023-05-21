package com.metropolitan.it355dz08.entity;

import javax.persistence.*;

@Entity
@Table(name = "address_status")
public class AddressStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id", nullable = false)
    private Integer id;

    @Column(name = "address_status", length = 30)
    private String addressStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddressStatus() {
        return addressStatus;
    }

    public void setAddressStatus(String addressStatus) {
        this.addressStatus = addressStatus;
    }

}