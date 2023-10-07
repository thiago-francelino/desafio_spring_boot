package com.faster.shop.ecommerce.services;


import com.faster.shop.ecommerce.dto.AddressDTO;
import com.faster.shop.ecommerce.entities.Address;
import com.faster.shop.ecommerce.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressService {
    @Autowired
    private AddressRepository repository;

    public List<AddressDTO> findAll(){
        List<Address> list =  repository.findAll();
        List<AddressDTO> listAddressDTO = list.stream().map(x -> new AddressDTO(x)).collect(Collectors.toList());
         return listAddressDTO;
    }
    public AddressDTO createAddress(AddressDTO addressDTO) {
        Address savedAddress = repository.save(new Address(addressDTO));
        AddressDTO listAddressDTO =  new AddressDTO(savedAddress);
        return listAddressDTO;
    }

    public String deleteAddress(Long id) {
        try {
            repository.deleteById(id);
            return "Objeto apagado da base de dados com sucesso";
        } catch (EmptyResultDataAccessException e) {
            return "Objeto não foi apagado da base de dados";
        }
    }

    public AddressDTO updateAddress(AddressDTO addressDTO) {
        Optional<Address> optionalAddress = repository.findById(addressDTO.getId());

        if (optionalAddress.isPresent()) {
            Address existingAddress = new Address(optionalAddress.get().getId(),addressDTO.getHouseNumber(),addressDTO.getComplement(),addressDTO.getStreet_address(),addressDTO.getCity(),addressDTO.getPostalCode());
            Address updatedAddress = repository.save(existingAddress);
            return new AddressDTO(updatedAddress);
        } else {
            throw new NoSuchElementException("Cliente não encontrado");
        }
    }

    public AddressDTO findById(Long id) {
        Optional<Address> searchedAddress = repository.findById(id);

        if (searchedAddress.isPresent()) {
            Address address = searchedAddress.get();
            return new AddressDTO(address);
        } else {
            return null;
        }
    }

}
