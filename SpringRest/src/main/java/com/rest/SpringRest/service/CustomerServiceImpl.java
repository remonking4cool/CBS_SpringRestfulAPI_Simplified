package com.rest.SpringRest.service;

import com.rest.SpringRest.entity.Customer;
import com.rest.SpringRest.repository.CustomerRepository;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    // Read Operation
    @Override public List<Customer> fetchCustomerList(){
        return (List<Customer>)
                customerRepository.findAll();
    }

    // Save Operation
    @Override
    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    // Update Operation
    @Override
    public Customer updateCustomer(Customer customer, Long CustomerAcctNumber){
        Customer cusDB
                = customerRepository.findById(CustomerAcctNumber)
                .get();
        if (Objects.nonNull(customer.getCustomerName())
            && !"".equalsIgnoreCase(
                    customer.getCustomerName())){
            cusDB.setCustomerName(
                    customer.getCustomerName());
        }
        if (Objects.nonNull(
                customer.getCustomerAddress())
            && !"".equalsIgnoreCase(
                    customer.getCustomerAddress())){
            cusDB.setCustomerAddress(
                    customer.getCustomerAddress());
        }
        cusDB.setCustomerBVN(customer.getCustomerBVN());
        cusDB.setCustomerPhoneNo(customer.getCustomerPhoneNo());
        return customerRepository.save(cusDB);

    }
    @Override
    public void deleteCustomerByCustomerAcctNumber(Long CustomerAcctNumber){
        customerRepository.deleteById(CustomerAcctNumber);
    }
}
