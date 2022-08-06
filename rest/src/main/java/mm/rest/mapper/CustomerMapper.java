package mm.rest.mapper;

import mm.rest.DTO.CustomerDTO;
import mm.rest.DTO.PhoneDTO;
import mm.rest.model.Customer;
import mm.rest.model.Phone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
//@Mapper
public interface CustomerMapper {

	@Mappings({
			@Mapping(source = "idDTO", target = "id"),
			@Mapping(source = "nameDTO", target = "name"),
			@Mapping(source = "surnameDTO", target = "surname")
	})
	Customer customerDTOtoCustomer(CustomerDTO customerDTO);

	@Mappings({
			@Mapping(source = "idDTO", target = "id"),
			@Mapping(source = "numberDTO", target = "number")
	})
	Phone phoneDTOToPhone(PhoneDTO phoneDTO);
}
