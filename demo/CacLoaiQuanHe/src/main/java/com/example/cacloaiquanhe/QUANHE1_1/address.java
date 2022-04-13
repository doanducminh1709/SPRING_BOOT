package com.example.cacloaiquanhe.QUANHE1_1;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne
    @JoinColumn(name = "person_id")
    private person pr;
}
