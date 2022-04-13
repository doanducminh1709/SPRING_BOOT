package com.example.buoi7.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//thuoc tinh khoa chinh de lien ket bang
    private String name;//ten tinh thanh pho
    private String slug;//chi muc cua ten thanh pho
    private String type;//kieu tinh hoac thanh pho
    private String nameWithType;//ten tinh ten thanh pho
    @Column(unique = true)
    private Long code;//ma tinh thanh pho , thuoc tinh nay la duy nhat
    @OneToMany(mappedBy = "province" ,fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JsonIgnore//khi minh khong muon xoa hoac giu du lieu nao minh se su dung json ignore
    List<District> districts;
}
