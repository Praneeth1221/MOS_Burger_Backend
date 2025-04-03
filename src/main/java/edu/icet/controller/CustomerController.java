package edu.icet.controller;

import edu.icet.dto.Customer;
import edu.icet.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@CrossOrigin
public class CustomerController {
    final CustomerService service;

    @GetMapping("/all")
    public List<Customer> all(){
        List<Customer> all = service.all();
        System.out.println(all);
        return all;
    }

    @PostMapping("/add")
    public void add(@RequestBody Customer customer){
        service.add(customer);
    }

    @GetMapping("/search")
    public Customer search(@RequestParam Integer id){
        return service.search(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Customer customer){
        service.update(customer);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Integer id){
        service.delete(id);
    }
}
