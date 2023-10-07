package com.faster.shop.ecommerce.dto;

import com.faster.shop.ecommerce.entities.Address;
import com.faster.shop.ecommerce.entities.Customer;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class AddressDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String postal_code;
    private String street_address;
    private  String city;
    private String house_number;
    private String complement;

    public AddressDTO(Address entity) {
        this.street_address = entity.getStreet();
        this.postal_code = entity.getPostalCode();
        this.city = entity.getCity();
        this.house_number = entity.getHouseNumber();
        this.complement = entity.getComplement();
    }

    public AddressDTO(String postal_code, String house_number, String street_address, String city, String complement) {
        this.postal_code = postal_code;
        this.house_number = house_number;
        this.street_address = street_address;
        this.city = city;
        this.complement = complement;
    }

    public AddressDTO(String postal_code, String house_number) {
        this.postal_code = postal_code;
        this.house_number = house_number;
    }

    public AddressDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet(String street_address) {
        this.street_address = street_address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHouseNumber() {
        return house_number;
    }

    public void setHouseNumber(String house_number) {
        this.house_number = house_number;
    }

    public void setPostalCode(String postal_code) {
        this.postal_code = postal_code;
    }
    public String getPostalCode() {
        return postal_code;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }
}
