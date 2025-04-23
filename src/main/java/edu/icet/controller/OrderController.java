package edu.icet.controller;

import edu.icet.dto.Order;
import edu.icet.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@CrossOrigin
public class OrderController {
    final OrderService service;

    @PostMapping("/add")
    public void add(@RequestBody Order orders){
        System.out.println(orders);
        service.add(orders);
    }
}
