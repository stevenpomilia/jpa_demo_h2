package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/api/orders/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable("id") long id) {
        Optional<Order> order = orderRepository.findById(id);

        if (order.isPresent()) {
            return new ResponseEntity<>(order.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/orders/")
    public ResponseEntity<List<Order>> getAllOrder() {
        List<Order> orders = orderRepository.findAll();

        if (orders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
        }
    }

    @PostMapping("/api/orders/add")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order _orders = orderRepository
                .save(new Order(order.getPurchase_total(), order.getShipped_location()));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
