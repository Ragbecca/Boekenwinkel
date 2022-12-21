package com.ragbecca.boekenwinkel.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;

@Entity
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @Column(length = 3)
    private int countryCode;

    @Getter
    @Setter
    @Column(length = 10, nullable = false)
    private int number;
}
