package com.faster.shop.ecommerce.repositories;


import com.faster.shop.ecommerce.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
