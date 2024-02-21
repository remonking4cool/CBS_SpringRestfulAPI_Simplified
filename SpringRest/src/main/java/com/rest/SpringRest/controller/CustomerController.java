package com.rest.SpringRest.controller;

import com.rest.SpringRest.entity.Customer;
import com.rest.SpringRest.service.CustomerService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    @Autowired private CustomerService customerService;

    // Save Operation
    @PostMapping("/customers")
    public Customer saveProduct(
            @Valid @RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }
    @GetMapping("/customers")
    public List<Customer> fetchCustomerList()
    {
        return customerService.fetchCustomerList();
    }

    // Update Operation
    @PutMapping("/customers/{acctNumber}")

    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable("acctNumber") Long CustomerAcctNumber){
        return customerService.updateCustomer(
                customer, CustomerAcctNumber);

    }

    // Post and Inquiry Transaction Operation
    @PostMapping("/transactions/{accountNumber}")

    public Customer updateTransaction(@RequestBody Customer customer, @PathVariable("accountNumber") Long CustomerAcctNumber){
        return customerService.updateCustomer(
                customer, CustomerAcctNumber);

    }

    // Delete Operation
    @DeleteMapping("/customers/{acctNumber}")

    public String deleteCustomerByCustomerAcctNumber(@PathVariable("acctNumber") Long CustomerAcctNumber){
        customerService.deleteCustomerByCustomerAcctNumber(CustomerAcctNumber);
        return "Deleted Successfully";
    }
}