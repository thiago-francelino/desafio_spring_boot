package com.faster.shop.ecommerce.entities;

import com.faster.shop.ecommerce.dto.ContactDTO;
import jakarta.persistence.*;

@Table(name = "tb_contact")
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String text_description;

    public Contact(String text_description, String type) {
        this.text_description = text_description;
        this.type = type;
    }

    public Contact(Long id, String text_description, String type) {
        this.text_description = text_description;
        this.type = type;
        this.id = id;
    }

    public Contact(ContactDTO contactDTO) {
        this.text_description = contactDTO.getText_description();
        this.type = contactDTO.getType();
    }

    public Contact() {
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
