package com.lambdaschool.crudyorders.controllers;

import com.lambdaschool.crudyorders.models.Customer;
import com.lambdaschool.crudyorders.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController
{
    @Autowired
    CustomerServices customerServices;
    // http://localhost:2019/customers/orders
    @GetMapping(value = "/orders", produces = "application/json")
    public ResponseEntity<?> listAllCustomers()
    {
        List<Customer> myList = customerServices.findAllCustomers();
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

    // http://localhost:2019/customers/customer/7

    // http://localhost:2019/customers/customer/77
    @GetMapping(value = "/customer/{customerId}", produces = "application/json")
    public ResponseEntity<?> findCustomerById(@PathVariable long customerId)
    {
        Customer c = customerServices.findCustomerById(customerId);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    // http://localhost:2019/customers/namelike/cin

    // http://localhost:2019/customers/namelike/mes
    @GetMapping(value = "/namelike/{subname}", produces = "application/json")
    public ResponseEntity<?> findCustomerByNameLike(@PathVariable String subname)
    {
        List<Customer> rtnList = customerServices.findByNameLike(subname);
        return new ResponseEntity<>(rtnList, HttpStatus.OK);
    }

}
