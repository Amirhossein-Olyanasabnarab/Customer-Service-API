package dk.amir.customerService.controller.customer;

import dk.amir.customerService.facade.CustomerFacade;
import dk.amir.customerService.model.Customer;
import dk.amir.customerService.model.LegalCustomer;
import dk.amir.customerService.model.RealCustomer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerFacade facade;

    @Autowired
    public CustomerController(CustomerFacade facade) {
        this.facade = facade;
    }

    @Operation(summary = "Get all customers", description = "Retrieve a list of all customers")
    @GetMapping
    public List<Customer> getCustomers() {
        return facade.getAllCustomers();
    }

    @Operation(summary = "Get customer by ID", description = "Retrieve a customer by its unique identifier")
    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return facade.getCustomerById(id);
    }

    @Operation(summary = "Add a new customer", description = "Create a new customer")
    @PostMapping
    public Customer createCustomer(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    description = "Customer object to be added.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    oneOf = {
                                            RealCustomer.class,
                                            LegalCustomer.class
                                    }
                            ),
                            examples = {
                                    @ExampleObject(
                                            name = "Real Customer Example",
                                            value = "{"
                                                    + "\"fullName\": \"John Doe\","
                                                    + "\"email\": \"john@gmail.com\","
                                                    + "\"phone\": \"+1234567890\","
                                                    + "\"type\": \"REAL\","
                                                    + "\"nationality\": \"UK\","
                                                    + "\"age\": \"42\""
                                                    + "}"
                                    ),
                                    @ExampleObject(
                                            name = "Legal Customer Example",
                                            value = "{"
                                                    + "\"fullName\": \"John Doe\","
                                                    + "\"email\": \"john@gmail.com\","
                                                    + "\"phone\": \"+1234567890\","
                                                    + "\"type\": \"LEGAL\","
                                                    + "\"companyName\": \"ABC Co\","
                                                    + "\"industry\": \"IT\""
                                                    + "}"
                                    )
                            }
                    )
            )
            @RequestBody Customer customer
    ) {
        return facade.createCustomer(customer);
    }

    @Operation(summary = "Update an existing customer", description = "Update the details of an existing customer")
    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id,
                                   @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                           required = true,
                                           description = "Customer object to be added.",
                                           content = @Content(
                                                   mediaType = "application/json",
                                                   schema = @Schema(
                                                           oneOf = {
                                                                   RealCustomer.class,
                                                                   LegalCustomer.class
                                                           }
                                                   ),
                                                   examples = {
                                                           @ExampleObject(
                                                                   name = "Real Customer Example",
                                                                   value = "{"
                                                                           + "\"fullName\": \"John Doe\","
                                                                           + "\"email\": \"john@gmail.com\","
                                                                           + "\"phone\": \"+1234567890\","
                                                                           + "\"type\": \"REAL\","
                                                                           + "\"nationality\": \"UK\","
                                                                           + "\"age\": \"42\""
                                                                           + "}"
                                                           ),
                                                           @ExampleObject(
                                                                   name = "Legal Customer Example",
                                                                   value = "{"
                                                                           + "\"fullName\": \"John Doe\","
                                                                           + "\"email\": \"john@gmail.com\","
                                                                           + "\"phone\": \"+1234567890\","
                                                                           + "\"type\": \"LEGAL\","
                                                                           + "\"companyName\": \"ABC Co\","
                                                                           + "\"industry\": \"IT\""
                                                                           + "}"
                                                           )
                                                   }
                                           )
                                   ) @RequestBody Customer customer) {
        return facade.updateCustomer(id, customer);
    }


    @Operation(summary = "Delete a customer", description = "Remove a customer")
    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        boolean success = facade.deleteCustomer(id);
        if (success) {
            return "Customer deleted successfully";
        } else {
            return "Customer could not be deleted";
        }
    }
}
