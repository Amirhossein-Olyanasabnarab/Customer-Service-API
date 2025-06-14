package dk.amir.customerService.service.impl;

import dk.amir.customerService.dao.CustomerDao;
import dk.amir.customerService.enums.CustomerType;
import dk.amir.customerService.model.Customer;
import dk.amir.customerService.model.LegalCustomer;
import dk.amir.customerService.model.RealCustomer;
import dk.amir.customerService.service.CustomerService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDao customerDao;
    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }



    @PostConstruct
    public void init() {

        addCustomer(RealCustomer.builder()
                .id(null)
                .fullName("John Doe")
                .phone("001 123 45 67")
                .email("john@gmail.com")
                .type(CustomerType.REAL)
                .nationality("US")
                .age("42")
                .build()
        );

        addCustomer(LegalCustomer.builder()
                .id(null)
                .fullName("Stevr Jobs")
                .phone("001 1234 68 90")
                .email("steve@app.com")
                .type(CustomerType.LEGAL)
                .companyName("Apple")
                .industry("Tech")
                .build()
        );
    }
    @Override
    public Customer addCustomer(Customer customer) {
        return customerDao.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        if (customerDao.isExist(id)){
            return customerDao.update(id,updatedCustomer);
        }
        return null;
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerDao.findById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerDao.findAll();
    }

    @Override
    public boolean deleteCustomer(Long id) {
        if (customerDao.isExist(id)){
            customerDao.delete(id);
            return true;
        }else
            return false;
    }
}
