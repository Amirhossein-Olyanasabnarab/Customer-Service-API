package dk.amir.customerService.dto;

import dk.amir.customerService.enums.CustomerType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor

public class LegalCustomer extends CustomerDto {

    @Schema(name = "companyName", example = "ABC Co")
    private String companyName;
    @Schema(name = "industry", example = "Tech")
    private String industry;

    public LegalCustomer(){
        this.setType(CustomerType.LEGAL);
    }
}
