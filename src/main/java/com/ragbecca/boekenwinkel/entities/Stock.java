package com.ragbecca.boekenwinkel.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @Column(nullable = false)
    private int quantity;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(nullable = false)
    private Book book;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(nullable = false)
    private Branch branch;
}
