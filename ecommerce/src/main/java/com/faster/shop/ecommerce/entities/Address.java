package com.faster.shop.ecommerce.entities;

import com.faster.shop.ecommerce.dto.AddressDTO;
import jakarta.persistence.*;

@Table(name = "tb_address")
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String postal_code;
    private String street_address;
    private  String city;
    private String house_number;
    private String complement;

    public Address(String postal_code,String street_address, String city, String house_number, String complement) {
        this.street_address = street_address;
        this.postal_code = postal_code;
        this.city = city;
        this.house_number = house_number;
        this.complement = complement;
    }

    public Address(Long id, String postal_code,String street_address, String city, String house_number, String complement) {
        this.id = id;
        this.street_address = street_address;
        this.postal_code = postal_code;
        this.city = city;
        this.house_number = house_number;
        this.complement = complement;
    }

    public Address() {

    }

    public Address(String postal_code, String house_number) {
        this.postal_code = postal_code;
        this.house_number = house_number;
    }

    public Address(AddressDTO addressDTO) {
        this.postal_code = addressDTO.getPostalCode();
        this.house_number = addressDTO.getHouseNumber();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
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
