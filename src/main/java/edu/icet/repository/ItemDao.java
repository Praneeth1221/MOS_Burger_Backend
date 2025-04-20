package edu.icet.repository;

import edu.icet.entity.ItemEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ItemDao extends CrudRepository<ItemEntity,Integer> {
    @Query(value = "SELECT * FROM item WHERE name = :name", nativeQuery = true)
    ItemEntity findByName(@Param("name") String name);
}
