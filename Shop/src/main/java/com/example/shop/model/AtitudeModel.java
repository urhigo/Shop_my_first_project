package com.example.shop.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "online_Shop")
public class AtitudeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private int price;

    @Column
    private String disc;

    @Column
    private String url;

    @Column
    private String type;

    @Column
    private long time;

    private String timeData;

}
