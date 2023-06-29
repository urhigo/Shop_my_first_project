package com.example.shop.helpPackeg;

import com.example.shop.model.AtitudeModel;
import lombok.Data;

@Data
public class AtitudeModelCurent {
    private int id;
    private String name;
    private int price;
    private String disc;
    private String url;
    private String type;
    private long time;
    private String timeData;
    private double eurPrice;
    private double usdPrice;

    public AtitudeModelCurent() {
    }

    public AtitudeModelCurent(AtitudeModel atitudeModel) {
        this.id = atitudeModel.getId();
        this.name = atitudeModel.getName();
        this.price = atitudeModel.getPrice();
        this.disc = atitudeModel.getDisc();
        this.url = atitudeModel.getUrl();
        this.type = atitudeModel.getType();
        this.time = atitudeModel.getTime();
        this.timeData = atitudeModel.getTimeData();
    }
}
