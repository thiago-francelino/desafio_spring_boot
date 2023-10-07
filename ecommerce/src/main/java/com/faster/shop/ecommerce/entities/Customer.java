package com.faster.shop.ecommerce.entities;

import com.faster.shop.ecommerce.dto.CustomerDTO;
import jakarta.persistence.*;

import java.util.Date;

@Table(name="tb_customer")
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date registration_date;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address_id;
    @OneToOne
    @JoinColumn(name = "contact_id")
    private Contact contact_id;

    public Customer(String name, Date registration_date, Address address, Contact contact) {
        this.name = name;
        this.registration_date = registration_date;
        this.address_id = address;
        this.contact_id = contact;
    }

    public Customer(String name, Date registration_date) {

    }

    public Customer() {

    }

    public Customer(CustomerDTO entity) {
        this.name = entity.getName();
        this.registration_date = entity.getRegistration_date();
    }

    public Contact getContactId() {
        return contact_id;
    }

    public void setContactId(Contact contact_id) {
        this.contact_id = contact_id;
    }

    public Address getAddressId() {
        return address_id;
    }

    public void setAddressId(Address address_id) {
        this.address_id = address_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
