package com.example.btvnb7.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private String name;
    private Long code;
}
