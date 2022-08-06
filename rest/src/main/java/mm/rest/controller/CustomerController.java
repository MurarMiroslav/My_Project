package mm.rest.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import mm.rest.DTO.CustomerDTO;
import mm.rest.model.Customer;
import mm.rest.service.CustomerServiceImpl;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "This is my Customer Controller")
@RestController
//@Controller
public class CustomerController {

	private final CustomerServiceImpl customerService;

	public CustomerController(CustomerServiceImpl customerService) {
		this.customerService = customerService;
	}

	@ApiOperation(value = "This will create a customer.", notes = "These are some notes about the API.")
	@PostMapping("/customer")
	public Customer createCustomer(@RequestBody CustomerDTO customerDTO) {
//	public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDTO customerDTO) {


//		Customer customer = new Customer();
//		customer.setId(customerDTO.getIdDTO());
//		customer.setName(customerDTO.getNameDTO());
//		customer.setSurname(customerDTO.getSurnameDTO());

		return customerService.createCustomer(customerDTO);
//		return new ResponseEntity<Customer>(customerService.createCustomer(customerDTO), HttpStatus.OK);
	}

	@PutMapping("/customer/{id}")
	public Customer updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
		return customerService.updateCustomer(id, customerDTO);
	}

	@PatchMapping("/customer/{id}")
	public Customer patchCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
		return customerService.patchCustomer(id, customerDTO);
	}

	@DeleteMapping("/customer/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomer(id);
	}
}
