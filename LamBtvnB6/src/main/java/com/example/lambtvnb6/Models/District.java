package com.example.lambtvnb6.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "District")
public class District {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)//mã tự dộng tăng
 private Long id;
 @Nationalized
 @Column(name = "Name")
 private String name;
 private String slug;
 @Nationalized
 private String type;
 @Nationalized
 private String name_with_type;
 private int code;

 @ManyToOne
 @JoinColumn(name = "province_id")
 private Province province;
}
