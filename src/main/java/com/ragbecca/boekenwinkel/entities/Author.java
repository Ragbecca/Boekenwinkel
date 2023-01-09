package com.ragbecca.boekenwinkel.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Author {
    @Id
    @SequenceGenerator(name = "authorSeq", sequenceName = "authorSeq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "authorSeq")
    @Column(name = "id", nullable = false)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @Column(nullable = false)
    @NotNull
    private String name;

    @Getter
    @Setter
    private String url;

    @Getter
    @Setter
    @ManyToOne
    private Address address;
}
