package com.example.Clase1111.demo.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Collection {
    private Integer number;
    private String date;
    private List<Customer> customers;
    private List<Property> properties;

    public Collection(String date, List<Customer> customers, List<Property> properties) {
        this.date = date;
        this.customers = customers;
        this.properties = properties;
    }
}
