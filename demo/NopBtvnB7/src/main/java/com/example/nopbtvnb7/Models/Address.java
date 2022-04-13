package com.example.nopbtvnb7.Models;

import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Nationalized
    private String name;
    private Long code;
    @CreationTimestamp
    private Timestamp created;

    @UpdateTimestamp
    private Timestamp updated;

   @ManyToOne
   @JoinColumn(name = "darling_id")
    private Darling darling;

}
