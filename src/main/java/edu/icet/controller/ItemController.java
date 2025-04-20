package edu.icet.controller;

import edu.icet.dto.Item;
import edu.icet.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService service;
    @GetMapping("/all")
    public List<Item> all() {
        return service.all();
    }

    @GetMapping("/search-by-name")
    public Item searchByName(@RequestParam String name) {
        System.out.println(name);
        Item item = service.findByName(name);
        System.out.println(item);
        return item;
    }

    @PostMapping("/add")
    public void add(@RequestBody Item item) {
        service.add(item);
    }

    @GetMapping("/search")
    public Item search(@RequestParam Integer id) {
        return service.search(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Item item) {
        service.update(item);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Integer id) {
        service.delete(id);
    }
}
