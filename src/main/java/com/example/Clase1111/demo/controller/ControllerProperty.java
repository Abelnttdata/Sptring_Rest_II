package com.example.Clase1111.demo.controller;


import com.example.Clase1111.demo.entity.Customer;
import com.example.Clase1111.demo.entity.Property;
import com.example.Clase1111.demo.repostiroy.CustomerRepository;
import com.example.Clase1111.demo.repostiroy.PropertyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/properties")
public class ControllerProperty {
    @Autowired
    PropertyRepository propertyRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ArrayList<Property> getProperties() {
        return propertyRepository.getPropertyArrayList();
    }

    @GetMapping("/{code}")
    public ResponseEntity<Property> getProperties(@PathVariable String code) throws nonexistentPropertyException {
        Optional<Property> optionalProperty= propertyRepository.searchProperty(code);
        if(optionalProperty.isEmpty()){
            throw new nonexistentPropertyException();
        }
        return ResponseEntity.ok(optionalProperty.get());
    }

    @PostMapping
    public void createProperty(@RequestBody Property property){
        propertyRepository.getPropertyArrayList().add(property);
    }


    @DeleteMapping("/{code}")
    public ResponseEntity<Property> deletePropertyException(@PathVariable String code) throws nonexistentPropertyException {
        Optional<Property> optionalProperty = propertyRepository.searchProperty(code);
        if(optionalProperty.isEmpty()){
            throw new nonexistentPropertyException();
        }
        deleteProperty(code);
        return ResponseEntity.ok(optionalProperty.get());
    }


    public void deleteProperty(String code){
        Optional<Property> optionalProperty= propertyRepository.searchProperty(code);
        optionalProperty.ifPresent(value -> propertyRepository.getPropertyArrayList().remove(value));
    }

    @PutMapping("/{code}")
    public ResponseEntity<Property> updatePropertyException(String code) throws nonexistentPropertyException{
        Optional<Property> optionalProperty = propertyRepository.searchProperty(code);
        if(optionalProperty.isEmpty()){
            throw new nonexistentPropertyException();
        }
        return ResponseEntity.ok(optionalProperty.get());
    }

}

