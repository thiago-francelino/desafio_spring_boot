package com.faster.shop.ecommerce.dto;

import com.faster.shop.ecommerce.entities.Contact;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ContactDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String text_description;

    public ContactDTO(Contact entity) {
        this.text_description = entity.getText_description();
        this.type = entity.getType();
    }

    public ContactDTO(String type, String text_description) {
        this.text_description = text_description;
        this.type = type;
    }

    public ContactDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText_description() {
        return text_description;
    }

    public void setText_description(String text_description) {
        this.text_description = text_description;
    }
}
