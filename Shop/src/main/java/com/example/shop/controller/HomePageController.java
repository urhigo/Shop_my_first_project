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

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class HomePageController {

    final
    FirebaseService firebaseService;

    private final ItemRep itemRep;

    public HomePageController(ItemRep itemRep, FirebaseService firebaseService) {
        this.itemRep = itemRep;
        this.firebaseService = firebaseService;
    }

    @GetMapping
    public String homePage(Model model){
        List<AtitudeModel> listAtribute = itemRep.findAll();
        listAtribute = listAtribute.stream().limit(5).collect(Collectors.toList());
        listAtribute.stream().forEach(i -> i.setUrl(firebaseService.getUrl(i.getUrl())));
        listAtribute = TimeDataFormat.timeDataFormat(listAtribute);
        model.addAttribute("items", listAtribute);
        return "index";
    }
}
