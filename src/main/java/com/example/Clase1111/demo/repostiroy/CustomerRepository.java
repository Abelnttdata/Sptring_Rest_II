package com.example.Clase1111.demo.repostiroy;

import com.example.Clase1111.demo.entity.Customer;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
@Getter @Setter
public class CustomerRepository {

    private ArrayList<Customer> customerArrayList= new ArrayList<>();

    public Optional<Customer> searchCustomer(String nombre){
        return customerArrayList.stream().filter(d -> d.getName().equals(nombre)).findFirst();
    }

}
