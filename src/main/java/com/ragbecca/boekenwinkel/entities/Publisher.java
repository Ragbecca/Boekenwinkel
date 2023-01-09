package com.ragbecca.boekenwinkel.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Publisher {
    @Id
    @SequenceGenerator(name = "publisherSeq", sequenceName = "publisherSeq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "publisherSeq")
    @Column(name = "id", nullable = false)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @Column(nullable = false)
    private String name;

    @Getter
    @Setter
    private String url;

    @Getter
    @Setter
    @ManyToOne
    private Address address;
}
