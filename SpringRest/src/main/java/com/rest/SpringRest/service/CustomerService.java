package com.rest.SpringRest.service;

import java.util.List;
import com.rest.SpringRest.entity.Customer;
public interface CustomerService {

    // Read Operation
    List<Customer> fetchCustomerList();

    // Save Operation
    Customer saveCustomer(Customer product);

    // Update Operation
    Customer updateCustomer(Customer product, Long productId);

    // Delete Operation
    void deleteCustomerByCustomerAcctNumber(Long productId);
}
