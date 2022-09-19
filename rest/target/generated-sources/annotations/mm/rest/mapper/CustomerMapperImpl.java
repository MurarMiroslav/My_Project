package mm.rest.mapper;

import javax.annotation.processing.Generated;
import mm.rest.DTO.CustomerDTO;
import mm.rest.DTO.PhoneDTO;
import mm.rest.model.Customer;
import mm.rest.model.Phone;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-31T15:43:02+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer customerDTOtoCustomer(CustomerDTO customerDTO) {
        if ( customerDTO == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerDTO.getIdDTO() );
        customer.setName( customerDTO.getNameDTO() );
        customer.setSurname( customerDTO.getSurnameDTO() );

        return customer;
    }

    @Override
    public Phone phoneDTOToPhone(PhoneDTO phoneDTO) {
        if ( phoneDTO == null ) {
            return null;
        }

        Phone phone = new Phone();

        phone.setId( phoneDTO.getIdDTO() );
        phone.setNumber( phoneDTO.getNumberDTO() );

        return phone;
    }
}
