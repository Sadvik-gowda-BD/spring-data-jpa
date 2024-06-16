package com.bank.springdatajpa.controller;


import com.bank.springdatajpa.entity.AddressEntity;
import com.bank.springdatajpa.entity.CustomerEntity;
import com.bank.springdatajpa.repo.AddressRepo;
import com.bank.springdatajpa.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private final CustomerRepo customerRepo;
    @Autowired
    private AddressRepo addressRepo;



    @GetMapping("/msg")
    public String getSimpleMsg() {
        return "Hello";
    }

    @GetMapping("/{custId}")
    public ResponseEntity<CustomerEntity> getAccount(@PathVariable("custId") String custId) {
        return ResponseEntity.ok(customerRepo.findById(custId).get());
    }

    @PostMapping("")
    public ResponseEntity<CustomerEntity> createCustomer(@RequestBody CustomerEntity customerEntity) {
        CustomerEntity response = customerRepo.save(customerEntity);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} is optional,
    // springboot automatically bind XML/JSON request to object
    @PutMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CustomerEntity> updateCustomer(CustomerEntity customerEntity) {
        return ResponseEntity.ok(customerRepo.save(customerEntity));
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteCustomer(@RequestParam("custId") String custId) {
        customerRepo.deleteById(custId);
        //return new ResponseEntity<>(HttpStatus.NO_CONTENT); This or below anything is fine
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/email/{emailId}")
    public ResponseEntity<CustomerEntity> getCustomerByEmailId(@PathVariable(name = "emailId", required = true) String emailId) {
        return ResponseEntity.ok(customerRepo.getCustomerByEmailId(emailId));
    }

    @GetMapping("")
    public ResponseEntity<List<CustomerEntity>> getCustomerByAge(
            @RequestParam(defaultValue = "0", name = "age", required = false) int age) {
        return ResponseEntity.ok(customerRepo.findByAge(age));
    }
}
