package edu.icet.service;

import edu.icet.dto.Item;

import java.util.List;

public interface ItemService {
    void add(Item item);

    Item search(Integer id);

    void update(Item item);

    void delete(Integer id);

    List<Item> all();

    Item findByName(String name);
}
