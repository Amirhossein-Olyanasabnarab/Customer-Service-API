package dk.amir.customerservice.model;

import dk.amir.customerservice.enums.CustomerType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public abstract class Customer {

    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private CustomerType type;
}
