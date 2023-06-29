package com.example.shop.repository;

import com.example.shop.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRep extends JpaRepository<OrderModel, Integer> {
}
