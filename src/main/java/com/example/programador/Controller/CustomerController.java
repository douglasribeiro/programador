package com.example.programador.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.programador.entities.Customer;
import com.example.programador.exception.ResourceNotFoundException;
import com.example.programador.repositorio.CustomerRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({ "/customer" })
public class CustomerController {
	
	CustomerRepository customerRepository;
	
	public CustomerController(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@GetMapping()
	public List<Customer> getAllCustomer() {
		return (List<Customer>) customerRepository.findAll();
	}  

	@PostMapping()
	public Customer createMusica(@Valid @RequestBody Customer customer) {
		return customerRepository.save(customer);
	}
	
	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteCustomer(@PathVariable(value = "id") Long customerId)
			throws ResourceNotFoundException {
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Esta codigo não existe :: " + customerId));

		customerRepository.delete(customer);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
