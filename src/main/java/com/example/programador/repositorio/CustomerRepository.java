package com.example.programador.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.example.programador.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
