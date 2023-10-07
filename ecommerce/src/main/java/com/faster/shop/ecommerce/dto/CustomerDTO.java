package com.faster.shop.ecommerce.dto;

import com.faster.shop.ecommerce.entities.Address;
import com.faster.shop.ecommerce.entities.Contact;
import com.faster.shop.ecommerce.entities.Customer;
import jakarta.persistence.*;

import java.util.Date;

public class CustomerDTO {
    private Long id;
    private String name;
    private Date registrationDate;
    private String postalCode;
    private String houseNumber;
    private String type;
    private String textDescription;

    public CustomerDTO(String name, Date registrationDate, String postalCode, String houseNumber, String type, String textDescription) {
        this.name = name;
        this.postalCode = postalCode;
        this.houseNumber = houseNumber;
        this.registrationDate = registrationDate;
        this.type = type;
        this.textDescription = textDescription;
    }

    public CustomerDTO(Customer entity) {
        this.name = entity.getName();
        this.postalCode = entity.getAddressId().getPostalCode();
        this.houseNumber = entity.getAddressId().getHouseNumber();
        this.type = entity.getContactId().getType();
        this.textDescription = entity.getContactId().getText_description();
        this.registrationDate = entity.getRegistration_date();
    }

    public String getText_description() {
        return textDescription;
    }

    public void setText_description(String textDescription) {
        this.textDescription = textDescription;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getRegistration_date() {
        return registrationDate;
    }

    public void setRegistration_date(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
