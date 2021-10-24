package com.sparta.mg.northwindrest.controllers;

import com.sparta.mg.northwindrest.entities.OrderEntity;
import com.sparta.mg.northwindrest.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class OrdersController {

    private final OrderRepository orderRepository;

    @Autowired
    public OrdersController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/orders")
    public List<OrderEntity> getALlProducts(){
        return orderRepository.findAll();
    }

    @GetMapping("/orders/{id}")
    public Optional<OrderEntity> getOrdersById(@PathVariable Integer id){
        return orderRepository.findById(id);
    }
}
