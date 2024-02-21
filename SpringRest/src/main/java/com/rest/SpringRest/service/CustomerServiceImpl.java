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

    // Read Operation for All Records
    @Override public List<Customer> fetchCustomerList(){
        return (List<Customer>)
                customerRepository.findAll();
    }

    // Read Operation Per Account

    // Save Operation
    @Override
    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    // Post and Inquiry Transaction
    @Override
    public Customer updateTransaction(Customer customer, Long CustomerAcctNumber) {
        Customer cusDB
                = customerRepository.findById(CustomerAcctNumber)
                .get();
        cusDB.setCustomerBalance(customer.getCustomerBalance());
        return customerRepository.save(cusDB);

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
        cusDB.setCustomerAge(customer.getCustomerAge());
        cusDB.setCustomerBalance(customer.getCustomerBalance());
        cusDB.setCustomerCIFId(customer.getCustomerCIFId());
        cusDB.setCustomerEmailAddress(customer.getCustomerEmailAddress());
        return customerRepository.save(cusDB);

    }
    @Override
    public void deleteCustomerByCustomerAcctNumber(Long CustomerAcctNumber){
        customerRepository.deleteById(CustomerAcctNumber);
    }
}
