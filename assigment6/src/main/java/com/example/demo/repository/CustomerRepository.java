package com.example.demo.repository;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository <CustomerDAO, Integer>{
    Iterable<Customer> getAllByUsername(String username);
    Iterable<Customer> getAllByCity(String city);
    Iterable<Customer> getAllByCountry(String country);

}
