package com.ragbecca.boekenwinkel.repository;

import com.ragbecca.boekenwinkel.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

    Address findByStreetAndHouseNumberAndCity(String street, int houseNumber, String city);
}