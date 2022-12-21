package com.ragbecca.boekenwinkel.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
public class Book {
    @Id
    @Column(name = "ISBN", nullable = false)
    @Getter
    @Setter
    private Long ISBN;

    @Getter
    @Setter
    @Column(nullable = false)
    private Date publicationDate;

    @Getter
    @Setter
    @Column(nullable = false)
    private String title;

    @Getter
    @Setter
    @Column(nullable = false)
    private float price;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(nullable = false)
    private Author author;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(nullable = false)
    private Publisher publisher;
}
