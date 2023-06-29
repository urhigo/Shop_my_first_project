package com.example.shop.repository;

import com.example.shop.model.AtitudeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRep extends JpaRepository<AtitudeModel, Integer> {
    AtitudeModel findById(int id);
}
