package com.example.Clase1111.demo.controller;

import com.example.Clase1111.demo.dto.CustomerDto;
import com.example.Clase1111.demo.entity.Customer;
import com.example.Clase1111.demo.repostiroy.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;



    @GetMapping
    public ArrayList<Customer> getCustomers() {
        return customerRepository.getCustomerArrayList();
    }

    @GetMapping("/{dni}")
    public ResponseEntity<Customer> getCustomers(@PathVariable String dni) throws nonexistentClientException {
        Optional<Customer> optionalCustomer= customerRepository.searchCustomer(dni);
        if(optionalCustomer.isEmpty()){
            throw new nonexistentClientException();
        }
        return ResponseEntity.ok(optionalCustomer.get());
    }

    @PostMapping
    public void createCustomer(@RequestBody Customer customer){
         /*
        Customer customer = new Customer();
        customer.setDni(customerDto.getDni());
        customer.setName(customerDto.getName());
        Customer customer= modelMapper.map(customerDto, Customer.class);
         */
        customerRepository.getCustomerArrayList().add(customer);
    }


    @DeleteMapping("/{dni}")
    public ResponseEntity<Customer> deleteCustomerException(@PathVariable String dni) throws nonexistentClientException {
        Optional<Customer> optionalCustomer = customerRepository.searchCustomer(dni);
        if(optionalCustomer.isEmpty()){
            throw new nonexistentClientException();
        }
        deleteCustomer(dni);
        return ResponseEntity.ok(optionalCustomer.get());
    }


    public void deleteCustomer(String dni){
        Optional<Customer> optionalCustomer= customerRepository.searchCustomer(dni);
        optionalCustomer.ifPresent(value -> customerRepository.getCustomerArrayList().remove(value));
    }

    @PutMapping("/{dni}")
    public ResponseEntity<Customer> updateCustomerException(String dni) throws nonexistentClientException{
        Optional<Customer> optionalCustomer = customerRepository.searchCustomer(dni);
        if(optionalCustomer.isEmpty()){
            throw new nonexistentClientException();
        }
        return ResponseEntity.ok(optionalCustomer.get());
    }



}
