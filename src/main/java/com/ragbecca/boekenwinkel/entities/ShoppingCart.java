package com.ragbecca.boekenwinkel.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class ShoppingCart {
    @Id
    @SequenceGenerator(name = "cartSeq", sequenceName = "cartSeq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "cartSeq")
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
    @JoinColumn(nullable = false)
    @ManyToOne
    private Book book;

    @Getter
    @Setter
    @JoinColumn(nullable = false)
    @ManyToOne
    private User user;
}
