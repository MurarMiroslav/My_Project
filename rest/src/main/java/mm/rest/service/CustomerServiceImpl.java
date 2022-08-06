package mm.rest.service;

import mm.rest.mapper.CustomerMapper;
import mm.rest.DTO.CustomerDTO;
import mm.rest.exception.ResourceNotFoundException;
import mm.rest.model.Customer;
import mm.rest.model.Phone;
import mm.rest.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerMapper customerMapper;
	private final CustomerRepository customerRepository;

	public CustomerServiceImpl(CustomerMapper customerMapper, CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
		this.customerMapper = customerMapper;
	}

	@Override
	public Customer createCustomer(CustomerDTO customerDTO) {
		Customer customer = customerMapper.customerDTOtoCustomer(customerDTO);
		Phone phone = customerMapper.phoneDTOToPhone(customerDTO.getPhoneDTO());
		customer.setPhone(phone);

		return customerRepository.save(customer);
//		return customerRepository.save(customerMapper.customerDTOtoCustomer(customerDTO));
	}

	public Customer updateCustomer(Long id, CustomerDTO customerDTO) {
		Customer customer = customerMapper.customerDTOtoCustomer(customerDTO);

//		Phone phone = customerMapper.phoneDTOToPhone(customerDTO.getPhoneDTO());
		Customer alreadySavedCustomer = customerRepository.findById(id).get();
		Phone phone = alreadySavedCustomer.getPhone();

		customer.setId(id);
		customer.setPhone(phone);

		customerRepository.save(customer);
		return customer;
	}

	public Customer patchCustomer(Long id, CustomerDTO customerDTO) {
		return customerRepository.findById(id).map(customer -> {
			if (customer.getName().equals("updatedCustomer1")) {
				customer.setName(customerDTO.getNameDTO());
			}
			return  customerRepository.save(customer);
		}).orElseThrow(ResourceNotFoundException::new);
	}

	public void deleteCustomer(Long id) {
		customerRepository.deleteById(id);
	}
}
