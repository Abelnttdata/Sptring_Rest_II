package com.example.Clase1111.demo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Property {
    private Integer Code;
    private String direction;
    private Integer amount;

    public Property(Integer code, String direction, Integer amount) {
        Code = code;
        this.direction = direction;
        this.amount = amount;
    }


}
