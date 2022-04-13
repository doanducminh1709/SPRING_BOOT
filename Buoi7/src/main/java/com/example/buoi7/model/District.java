package com.example.buoi7.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Nationalized
    @Column(name = "name", nullable = false)
    //khong the trung lap duoc
    private String name;//ten quan huyen
    private String slug;//chi muc cua ten quan huyen
    private String type;//kieu quan huyen , thanh pho
    @Nationalized
    private String nameWithType;//ten quan huyen
    private String path;//ten duong
    private String pathWithType;//ten duong voi ten kieu
    @Column(unique = true)
    private Long code;//ma quan huyen
    private Long parentCode;//ma tinh thanh pho

    @ManyToOne
    @JoinColumn(name = "province_id")
    private Province province;
}
