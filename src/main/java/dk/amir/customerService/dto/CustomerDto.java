package dk.amir.customerService.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import dk.amir.customerService.enums.CustomerType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@JsonTypeInfo(include = JsonTypeInfo.As.PROPERTY,
        use = JsonTypeInfo.Id.NAME,
        property = "type"
)

@JsonSubTypes({
        @JsonSubTypes.Type(value = RealCustomerDto.class, name = "REAL"),
        @JsonSubTypes.Type(value = LegalCustomerDto.class, name = "LEGAL")
})

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor

@Schema(description = "Customer entity representing a customer service")
public abstract class CustomerDto {

    @Schema(name = "id", example = "1")
    private Long id;
    @Schema(name = "fullName", example = "John Doe")
    private String fullName;
    @Schema(name = "email", example = "johnDoe@gmail.com")
    private String email;
    @Schema(name = "phone", example = "+1 23 45 67 89")
    private String phone;
    @Schema(name = "type", example = "REAL")
    private CustomerType type;
}
