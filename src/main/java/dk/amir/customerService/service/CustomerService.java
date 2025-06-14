package dk.amir.customerService.service;

import dk.amir.customerService.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer addCustomer(Customer customer);
    Customer updateCustomer(Long id, Customer updatedCustomer);
    Customer getCustomerById(Long id);
    List<Customer> getAllCustomers();
    boolean deleteCustomer(Long id);
}
