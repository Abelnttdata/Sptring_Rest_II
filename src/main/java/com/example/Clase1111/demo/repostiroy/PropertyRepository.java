package com.example.Clase1111.demo.repostiroy;


import com.example.Clase1111.demo.entity.Customer;
import com.example.Clase1111.demo.entity.Property;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
@Getter  @Setter
public class PropertyRepository {
    private ArrayList<Property> propertyArrayList= new ArrayList<>();

    public Optional<Property> searchProperty(String code){
        return propertyArrayList.stream().filter(d -> d.getCode().equals(code)).findFirst();
    }
}
