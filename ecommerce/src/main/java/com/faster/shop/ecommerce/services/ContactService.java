package com.faster.shop.ecommerce.services;

import com.faster.shop.ecommerce.dto.ContactDTO;
import com.faster.shop.ecommerce.entities.Contact;
import com.faster.shop.ecommerce.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactService {

    @Autowired
    private ContactRepository repository;
    public List<ContactDTO> findAll(){
        List<Contact> list = repository.findAll();
        List<ContactDTO> listContactDTO = list.stream().map(x -> new ContactDTO(x)).collect(Collectors.toList());
        return listContactDTO;
    }
    
    public ContactDTO createContact(ContactDTO contactDTO) {
        Contact savedContact = repository.save(new Contact(contactDTO));
        return new ContactDTO(savedContact);
    }

    public String deleteContact(Long id) {
        try {
            repository.deleteById(id);
            return "Objeto apagado da base de dados com sucesso";
        } catch (EmptyResultDataAccessException e) {
            return "Objeto não foi apagado da base de dados";
        }
    }

    public ContactDTO updateContact(ContactDTO contactDTO) {
        Optional<Contact> optionalContact = repository.findById(contactDTO.getId());

        if (optionalContact.isPresent()) {
            Contact existingContact = new Contact(optionalContact.get().getId(),contactDTO.getType(),contactDTO.getText_description());
            Contact updatedContact = repository.save(existingContact);
            return new ContactDTO(updatedContact);
        } else {
            throw new NoSuchElementException("Cliente não encontrado");
        }
    }

    public ContactDTO findById(Long id) {
        Optional<Contact> searchedContact = repository.findById(id);

        if (searchedContact.isPresent()) {
            Contact contact = searchedContact.get();
            return new ContactDTO(contact);
        } else {
            return null;
        }
    }
}
