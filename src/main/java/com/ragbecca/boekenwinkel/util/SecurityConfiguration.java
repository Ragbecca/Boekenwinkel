package com.ragbecca.boekenwinkel.util;

import com.ragbecca.boekenwinkel.entities.Address;
import com.ragbecca.boekenwinkel.entities.PhoneNumber;
import com.ragbecca.boekenwinkel.entities.User;
import com.ragbecca.boekenwinkel.repository.AddressRepository;
import com.ragbecca.boekenwinkel.repository.PhoneNumberRepository;
import com.ragbecca.boekenwinkel.repository.UserRepository;
import com.ragbecca.boekenwinkel.service.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration {
    @Autowired
    private PhoneNumberRepository phoneNumberRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    AuthUserService authUserService;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.cors();
        http.authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/test").permitAll()
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/address/get-all", "/address/add").access(new WebExpressionAuthorizationManager("hasRole('EMPLOYEE') or hasRole('OWNER')"))
                        .requestMatchers("/db/**").access(new WebExpressionAuthorizationManager("hasRole('ADMIN') and hasRole('DBA')"))
                        .anyRequest().authenticated())
                .httpBasic();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setId(1L);
        phoneNumber.setNumber(1010101010);
        phoneNumber.setCountryCode(31);

        Address address = new Address();
        address.setId(1L);
        address.setStreet("Daam Fockemalaan");
        address.setHouseNumber(22);
        address.setCity("Amersfoort");
        address.setCountry("Netherlands");

        if (phoneNumberRepository.findById(1L).isEmpty()) {
            phoneNumberRepository.save(phoneNumber);
        }

        if (addressRepository.findById(1L).isEmpty()) {
            addressRepository.save(address);
        }

        if (userRepository.findById("rebeccadj2003@gmail.com").isEmpty()) {
            User user = new User();
            user.setUsername("Rebeccadj2003@gmail.com");
            user.setDisplayName("Rebecca de Jong");
            user.setPassword(passwordEncoder().encode("Welkom123!"));
            user.setRole("OWNER");
            user.setPhoneNumber(phoneNumber);
            user.setAddress(address);
            userRepository.save(user);
        }

        return http.build();
    }

    @Bean
    public AuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(this.authUserService);
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
