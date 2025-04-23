package edu.icet.repository;

import edu.icet.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailDao extends JpaRepository<OrderDetailEntity, Integer> {

}
