package com.example.shop.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="list_order")
@Data
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nameUser")
    private String nameUser;

    @Column(name = "telephoneNumber")
    private String telephoneNumber;

    @Column(name = "id_order")
    private int idOrder;
}
