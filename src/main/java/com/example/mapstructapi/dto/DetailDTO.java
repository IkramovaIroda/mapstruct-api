package com.example.mapstructapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetailDTO {

    private Integer id;
    private String name;
    private String description;
    private String value;
//    private String productId;

}
