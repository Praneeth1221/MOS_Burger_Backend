package edu.icet.service.Impl;

import edu.icet.dto.Customer;
import edu.icet.entity.CustomerEntity;
import edu.icet.repository.CustomerDao;
import edu.icet.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    final ModelMapper mapper;
    final CustomerDao dao;

    @Override
    public List<Customer> all() {
        ArrayList<Customer> objects = new ArrayList<>();
        dao.findAll().forEach(customerEntity -> {
            objects.add(mapper.map(customerEntity, Customer.class));
        });
        return objects;
    }

    @Override
    public void add(Customer customer) {
        dao.save(mapper.map(customer, CustomerEntity.class));
    }

    @Override
    public Customer search(Integer id) {
        return mapper.map(dao.findById(id), Customer.class);
    }

    @Override
    public void update(Customer customer) {
        dao.save(mapper.map(customer,CustomerEntity.class));
    }

    @Override
    public void delete(Integer id) {
        dao.deleteById(id);
    }
}
