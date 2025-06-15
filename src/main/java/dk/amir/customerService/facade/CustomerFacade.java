package dk.amir.customerService.facade;

import dk.amir.customerService.dto.CustomerDto;

import java.util.List;

public interface CustomerFacade {

    CustomerDto createCustomer(CustomerDto customerDto);
    CustomerDto updateCustomer(Long id, CustomerDto updatedCustomerDto);
    List<CustomerDto> getAllCustomers();
    CustomerDto getCustomerById(Long id);
    boolean deleteCustomer(Long id);
}
