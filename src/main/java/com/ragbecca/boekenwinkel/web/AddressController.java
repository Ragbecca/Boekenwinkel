package com.ragbecca.boekenwinkel.web;

import com.ragbecca.boekenwinkel.entities.Address;
import com.ragbecca.boekenwinkel.repository.AddressRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;
    @PostMapping("/address/add")
    String createAddress(@Valid @RequestBody Address address) {
        if (addressRepository.findByStreetAndHouseNumberAndCity(
                address.getStreet(), address.getHouseNumber(), address.getCity()) != null) {
            return "Er bestond al een adres met die gegevens";
        }
        addressRepository.save(address);
        Long id = addressRepository.findByStreetAndHouseNumberAndCity(
                address.getStreet(), address.getHouseNumber(), address.getCity()).getId();;
        return String.valueOf(id);
    }

    @GetMapping("/address/get-all")
    List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

}
