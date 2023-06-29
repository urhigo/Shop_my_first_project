package com.example.shop.helpPackeg;

import com.example.shop.model.AtitudeModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TimeDataFormat {

    public static List<AtitudeModel> timeDataFormat(List<AtitudeModel> listAtribute){
        for (AtitudeModel atribute: listAtribute) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm dd.MM");
            atribute.setTimeData(simpleDateFormat.format(new Date(atribute.getTime())));
        }
        return listAtribute;
    }
}
