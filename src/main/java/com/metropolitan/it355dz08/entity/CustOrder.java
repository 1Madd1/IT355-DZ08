package com.metropolitan.it355dz08.entity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "cust_order")
public class CustOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private Integer id;

    @Column(name = "order_date")
    private Instant orderDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "shipping_method_id")
    private ShippingMethod shippingMethod;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dest_address_id")
    private Address destAddress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Instant orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ShippingMethod getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public Address getDestAddress() {
        return destAddress;
    }

    public void setDestAddress(Address destAddress) {
        this.destAddress = destAddress;
    }

    @Override
    public String toString() {
        return "Order date: " + orderDate + "; Customer: " + customer + "; Shipping method: " + shippingMethod + "; Destination address: " + destAddress;
    }
}