package com.ragbecca.boekenwinkel.service;

import com.ragbecca.boekenwinkel.entities.User;
import com.ragbecca.boekenwinkel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (userRepository.findById(username).isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        User user = userRepository.findById(username).get();
        return user;
    }
}
