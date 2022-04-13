package com.example.lambtvnb6.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "District")
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Nationalized
    private String name;
    @Nationalized
    private String type;
    private String slug;
    @Nationalized
    private String name_with_type;
    private Integer code;
    private int parent_code;

    @OneToMany(mappedBy = "province" , fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
    @JsonIgnore
    List<District> districtList;

}
