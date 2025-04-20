package edu.icet.service.Impl;

import edu.icet.dto.Item;
import edu.icet.entity.ItemEntity;
import edu.icet.repository.ItemDao;
import edu.icet.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class ItemServiceImpl implements ItemService {
    private final ItemDao dao;
    private final ModelMapper mapper;

    @Override
    public void add(Item item) {
        dao.save(mapper.map(item, ItemEntity.class));
    }

    @Override
    public Item search(Integer id) {
        return mapper.map(dao.findById(id), Item.class);
    }

    @Override
    public void update(@RequestBody Item item) {
        dao.save(mapper.map(item, ItemEntity.class));
    }

    @Override
    public void delete(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public List<Item> all() {
        ArrayList<Item> objects = new ArrayList<>();
        dao.findAll().forEach(itemEntity -> {
            objects.add(mapper.map(itemEntity, Item.class));
        });
        return objects;
    }

    @Override
    public Item findByName(String name) {
        return mapper.map(dao.findByName(name), Item.class);
    }
}
