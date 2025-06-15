package dk.amir.customerService.facade.impl;

import dk.amir.customerService.dto.CustomerDto;
import dk.amir.customerService.facade.CustomerFacade;
import dk.amir.customerService.mapper.CustomerMapper;
import dk.amir.customerService.model.Customer;
import dk.amir.customerService.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerFacadeImpl implements CustomerFacade {


    private final CustomerService customerService;
    private final CustomerMapper mapper;
    @Autowired
    public CustomerFacadeImpl(CustomerService customerService, CustomerMapper mapper) {
        this.customerService = customerService;
        this.mapper = mapper;
    }


    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer entity = mapper.toEntity(customerDto);
        entity = customerService.addCustomer(entity);
        return mapper.toDto(entity);
    }

    @Override
    public CustomerDto updateCustomer(Long id, CustomerDto updatedCustomerDto) {
        Customer entity = mapper.toEntity(updatedCustomerDto);
        entity = customerService.updateCustomer(id, entity);
        return mapper.toDto(entity);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerService.getAllCustomers()
                .stream().map(mapper::toDto)
                .toList();
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        return mapper.toDto(customerService.getCustomerById(id));
    }

    @Override
    public boolean deleteCustomer(Long id) {
        return customerService.deleteCustomer(id);
    }
}
