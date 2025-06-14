package dk.amir.customerservice.model;

import dk.amir.customerservice.enums.CustomerType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor

public class LegalCustomer extends Customer {

    private String companyName;
    private String industry;

    public LegalCustomer() {
        this.setType(CustomerType.LEGAL);
    }
}
