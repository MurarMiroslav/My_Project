package mm.rest.service;

import mm.rest.DTO.CustomerDTO;
import mm.rest.model.Customer;

public interface CustomerService {

	public Customer createCustomer(CustomerDTO customerDTO);
}
