package com.ragbecca.boekenwinkel.repository;

import com.ragbecca.boekenwinkel.entities.Publisher;
import com.ragbecca.boekenwinkel.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, String> {
}
