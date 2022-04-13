package com.example.luyentap.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class District {
    private String name;
    private String slug;
    private String type;
    @JsonProperty("name_with_type")//objectMapper
    private String name_with_type2;
    private String code;
}
