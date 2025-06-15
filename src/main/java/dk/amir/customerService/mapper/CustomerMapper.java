package dk.amir.customerService.mapper;

import dk.amir.customerService.dto.CustomerDto;
import dk.amir.customerService.dto.LegalCustomerDto;
import dk.amir.customerService.dto.RealCustomerDto;
import dk.amir.customerService.model.Customer;
import dk.amir.customerService.model.LegalCustomer;
import dk.amir.customerService.model.RealCustomer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    RealCustomer toEntity(RealCustomerDto dto);
    RealCustomerDto toDto(RealCustomer entity);

    LegalCustomer toEntity(LegalCustomerDto dto);
    LegalCustomerDto toDto(LegalCustomer entity);

    default Customer toEntity(Object dto) {
        if (dto instanceof RealCustomerDto){
            return toEntity((RealCustomerDto) dto);
        }else if (dto instanceof LegalCustomerDto){
            return toEntity((LegalCustomerDto) dto);
        }
        throw new IllegalArgumentException("Cannot convert " + dto + " to Entity");
    }

    default CustomerDto toDto(Customer entity) {
        if (entity instanceof RealCustomer){
            return toDto((RealCustomer) entity);
        }else if (entity instanceof LegalCustomer){
            return toDto((LegalCustomer) entity);
        }
        throw new IllegalArgumentException("Cannot convert " + entity + " to Dto");
    }
}
