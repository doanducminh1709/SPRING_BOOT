package com.hit.baiktraweb.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Darling")
public class Darling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Nationalized
    private String name;
    private String phone;
    private String email;
    private String favorite;
    private String status;
    Timestamp created;
    Timestamp updated;
    @OneToMany(mappedBy = "darling" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JsonIgnore
    List<Address> addressList;

}
