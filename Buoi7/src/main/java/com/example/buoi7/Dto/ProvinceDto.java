package com.example.buoi7.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProvinceDto {
    private String name;
    private String type;
    private Long code;
    //k truyen slug vi no la ten
}
