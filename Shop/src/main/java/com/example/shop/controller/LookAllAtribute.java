package com.example.shop.controller;

import com.example.shop.helpPackeg.TimeDataFormat;
import com.example.shop.model.AtitudeModel;
import com.example.shop.repository.ItemRep;
import com.example.shop.services.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/LookAll")
public class LookAllAtribute {
    private final ItemRep itemRep;

    public LookAllAtribute(ItemRep itemRep, FirebaseService firebaseService) {
        this.itemRep = itemRep;
        this.firebaseService = firebaseService;
    }
    private final FirebaseService firebaseService;

    @GetMapping
    public String lookAll(Model model){
        List<AtitudeModel> listItems = itemRep.findAll();
        model.addAttribute("items", listItems);
        listItems.stream().forEach(i -> i.setUrl(firebaseService.getUrl(i.getUrl())));
        listItems = TimeDataFormat.timeDataFormat(listItems);
        return "LookAllAtribute";
    }
}
