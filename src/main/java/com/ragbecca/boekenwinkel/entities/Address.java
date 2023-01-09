package com.ragbecca.boekenwinkel.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Address {
    @Id
    @SequenceGenerator(name = "addressSeq", sequenceName = "addressSeq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "addressSeq")
    @Column(name = "id", nullable = false)
    @Getter
    @Setter
    private Long id;

    @Column(nullable = false)
    @Getter
    @Setter
    private String street;

    @Column(nullable = false)
    @Getter
    @Setter
    private int houseNumber;

    @Column(length = 3)
    @Getter
    @Setter
    private String houseNumberAddon;

    @Column(nullable = false)
    @Getter
    @Setter
    private String city;

    @Getter
    @Setter
    private String country;
}
