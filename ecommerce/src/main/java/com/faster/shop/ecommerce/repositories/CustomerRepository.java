package com.faster.shop.ecommerce.repositories;

import com.faster.shop.ecommerce.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    //pesquisa pelo nome
    @Query("SELECT c FROM Customer c WHERE c.name = ?1")
    List<Customer> findByName(String name);
}
