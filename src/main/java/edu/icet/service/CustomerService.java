package edu.icet.service;

import edu.icet.dto.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> all();

    void add(Customer customer);

    Customer search(Integer id);

    void update(Customer customer);

    void delete(Integer id);
}
