package com.ragbecca.boekenwinkel.repository;

import com.ragbecca.boekenwinkel.entities.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long> {
}