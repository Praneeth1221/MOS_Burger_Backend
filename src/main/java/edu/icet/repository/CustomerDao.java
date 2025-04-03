package edu.icet.repository;

import edu.icet.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerDao extends CrudRepository<CustomerEntity,Integer> {
}
