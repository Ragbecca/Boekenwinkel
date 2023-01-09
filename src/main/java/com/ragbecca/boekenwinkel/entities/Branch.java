package com.ragbecca.boekenwinkel.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Branch {
    @Id
    @SequenceGenerator(name = "branchSeq", sequenceName = "branchSeq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "branchSeq")
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
    @JoinColumn(nullable = false)
    @ManyToOne
    private Address address;
}
