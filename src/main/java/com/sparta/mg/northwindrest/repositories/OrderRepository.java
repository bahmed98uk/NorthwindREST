package com.sparta.mg.northwindrest.repositories;

import com.sparta.mg.northwindrest.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
}