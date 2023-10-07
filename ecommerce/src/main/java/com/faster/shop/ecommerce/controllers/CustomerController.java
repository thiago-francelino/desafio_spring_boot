package com.faster.shop.ecommerce.controllers;

import com.faster.shop.ecommerce.dto.CustomerDTO;
import com.faster.shop.ecommerce.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;
    @GetMapping
    public ResponseEntity<List<CustomerDTO>> findAll() {
        List<CustomerDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO savedCustomerDTO = service.createCustomer(customerDTO);
        return ResponseEntity.ok().body(savedCustomerDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        String message = service.deleteCustomer(id);
        return ResponseEntity.ok().body(message);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        customerDTO.setId(id);
        CustomerDTO updatedCustomer = service.updateCustomer(customerDTO);
        return ResponseEntity.ok().body(updatedCustomer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> findById(@PathVariable Long id) {
        CustomerDTO searchedCustomer = service.findById(id);
        return ResponseEntity.ok().body(searchedCustomer);
    }

    @GetMapping("/search")//pesquisa pelo nome   http://localhost:8080/customers/search?name=Carlos
    public ResponseEntity<List<CustomerDTO>> findByName(@RequestParam("name") String name) {
        List<CustomerDTO> searchedCustomer = service.findByName(name);
        return ResponseEntity.ok().body(searchedCustomer);
    }

}
