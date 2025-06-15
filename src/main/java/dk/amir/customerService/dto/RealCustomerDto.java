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

public class RealCustomerDto extends CustomerDto {

    @Schema(name = "nationality", example = "Canada")
    private String nationality;
    @Schema(name = "age", example = "42")
    private String age;

    public RealCustomerDto(){
        this.setType(CustomerType.REAL);
    }
}
