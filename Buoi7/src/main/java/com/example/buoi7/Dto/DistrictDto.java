package com.example.buoi7.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DistrictDto {
    private String name;
    private String type;
    private String path;
    private Long code;
    private Long parentCode;
}
