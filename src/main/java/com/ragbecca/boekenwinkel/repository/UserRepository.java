package com.ragbecca.boekenwinkel.repository;

import com.ragbecca.boekenwinkel.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}