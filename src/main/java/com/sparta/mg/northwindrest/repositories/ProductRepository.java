package com.sparta.mg.northwindrest.repositories;

import com.sparta.mg.northwindrest.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
}