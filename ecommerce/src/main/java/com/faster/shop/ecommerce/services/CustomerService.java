package com.faster.shop.ecommerce.services;

import com.faster.shop.ecommerce.dto.AddressDTO;
import com.faster.shop.ecommerce.dto.ContactDTO;
import com.faster.shop.ecommerce.dto.CustomerDTO;
import com.faster.shop.ecommerce.dto.ViaCepResponseDTO;
import com.faster.shop.ecommerce.entities.Address;
import com.faster.shop.ecommerce.entities.Contact;
import com.faster.shop.ecommerce.entities.Customer;
import com.faster.shop.ecommerce.repositories.AddressRepository;
import com.faster.shop.ecommerce.repositories.ContactRepository;
import com.faster.shop.ecommerce.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repositoryCustomer;
    @Autowired
    private ContactRepository repositoryContact;
    @Autowired
    private AddressRepository repositoryAddress;
    @Autowired
    private ViaCepService repositoryViaCep;
    public List<CustomerDTO> findAll() {

        List<Customer> list = repositoryCustomer.findAll();
        List<CustomerDTO> listDTO = new ArrayList<>();
        for (Customer customer : list){
            listDTO.add(new CustomerDTO(customer));
        }
        return listDTO;
    }
//Cria customer, addres e contact
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {

        ViaCepResponseDTO viaCepResponse = repositoryViaCep.consultCep(customerDTO.getPostalCode());

        Address savedAddress = repositoryAddress.save(new Address(viaCepResponse.getCep(), viaCepResponse.getLogradouro(),
                viaCepResponse.getLocalidade(), customerDTO.getHouseNumber(), viaCepResponse.getComplemento()));
        new AddressDTO(savedAddress);

        Contact savedContact = repositoryContact.save(new Contact(customerDTO.getText_description(),customerDTO.getType()));
        new ContactDTO(savedContact);

        Customer savedCustomer = repositoryCustomer.save(new Customer(customerDTO.getName(), customerDTO.getRegistration_date(),
                savedAddress, savedContact));
        new CustomerDTO(savedCustomer);

        return customerDTO;
    }
    //Deleta customer, addres e contact
    public String deleteCustomer(Long id) {
        try {
            Optional<Customer> optionalCustomer = repositoryCustomer.findById(id);
            repositoryCustomer.deleteById(id);
            repositoryContact.deleteById(optionalCustomer.get().getContactId().getId());
            repositoryAddress.deleteById(optionalCustomer.get().getAddressId().getId());
            return "Objeto apagado da base de dados com sucesso";
        } catch (EmptyResultDataAccessException e) {
            return "Objeto não foi apagado da base de dados";
        }
    }
    //Atualiza customer, address e contact
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        Optional<Customer> optionalCustomer = repositoryCustomer.findById(customerDTO.getId());
        if (optionalCustomer.isPresent()) {
            Customer existingCustomer = optionalCustomer.get();
            existingCustomer.setName(customerDTO.getName());
            existingCustomer.setRegistration_date(customerDTO.getRegistration_date());

            if (customerDTO.getPostalCode() != null) {
                ViaCepResponseDTO viaCepResponse = repositoryViaCep.consultCep(customerDTO.getPostalCode());

                if (existingCustomer.getAddressId() != null) {

                    Address existingAddress = new Address(existingCustomer.getAddressId().getId(),viaCepResponse.getCep(),viaCepResponse.getLogradouro(), viaCepResponse.getLocalidade(), customerDTO.getHouseNumber(), viaCepResponse.getComplemento());
                    repositoryAddress.save(existingAddress);

                    Contact existingContact = new Contact(existingCustomer.getContactId().getId(),customerDTO.getType(),customerDTO.getText_description());
                    repositoryContact.save(existingContact);
                }
                return customerDTO;
            }else {
                throw new NoSuchElementException("CEP não informado");
            }
        } else {
            throw new NoSuchElementException("Cliente não encontrado");
        }
    }
//bsuca pelo id
    public CustomerDTO findById(Long id) {
        Optional<Customer> searchedCustomer = repositoryCustomer.findById(id);

        if (searchedCustomer.isPresent()) {
            Customer customer = searchedCustomer.get();
            return new CustomerDTO(customer);
        } else {
            return null;
        }
    }
//Pesquisa pelo nome
    public List<CustomerDTO> findByName(String name) {
        List<Customer> searchedCustomer = repositoryCustomer.findByName(name);
        return searchedCustomer.stream()
                .map(customerObj -> new CustomerDTO(customerObj))
                .collect(Collectors.toList());

}}