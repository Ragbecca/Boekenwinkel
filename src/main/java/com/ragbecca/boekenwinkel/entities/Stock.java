package com.ragbecca.boekenwinkel.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Stock {
    @Id
    @SequenceGenerator(name = "stockSeq", sequenceName = "stockSeq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "stockSeq")
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
