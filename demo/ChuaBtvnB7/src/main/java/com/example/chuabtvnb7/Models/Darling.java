package com.example.chuabtvnb7.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Darlings")
public class Darling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Nationalized
    private String name;
    private String phone;
    private String email;
    @Nationalized
    private String favourite;

//    @CreationTimestamp
//    private Timestamp created;
//    @UpdateTimestamp
//    private Timestamp updated;
    private Integer status;

    @OneToMany(mappedBy = "darling" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Address> address;
}
