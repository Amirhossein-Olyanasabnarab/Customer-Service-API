package dk.amir.customerService.facade;

import dk.amir.customerService.model.Customer;
import dk.amir.customerService.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerFacade {

    private final CustomerService customerService;
    @Autowired
    public CustomerFacade(CustomerService customerService) {
        this.customerService = customerService;
    }

    public List<Customer> getAllCustomers() {
      return customerService.getAllCustomers();
    }

    public Customer getCustomerById(Long id) {
        return customerService.getCustomerById(id);
    }

    public Customer createCustomer(Customer customer) {
        return customerService.addCustomer(customer);
    }

    public Customer updateCustomer(Long id, Customer customer) {
        return customerService.updateCustomer(id, customer);
    }

    public boolean deleteCustomer(Long id) {
        return customerService.deleteCustomer(id);
    }
}
