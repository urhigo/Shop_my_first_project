package com.example.shop.controller;

import com.example.shop.model.AtitudeModel;
import com.example.shop.repository.ItemRep;
import com.example.shop.services.FirebaseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/AddNew")
public class AddNewAtribute {

    final
    FirebaseService firebaseService;

    final
    ItemRep itemRep;

    public AddNewAtribute(ItemRep itemRep, FirebaseService firebaseService) {
        this.itemRep = itemRep;
        this.firebaseService = firebaseService;
    }

    @GetMapping
    public String addNew(){
        return "AddNewAtribute";
    }

    @PostMapping
    public RedirectView addNewAtribute(@RequestParam String name, @RequestParam String disc,
                                       @RequestParam Integer price, @RequestParam String type,
                                       @RequestParam MultipartFile file) throws Exception {
        AtitudeModel atitudeModel = new AtitudeModel();
        atitudeModel.setName(name);
        atitudeModel.setDisc(disc);
        atitudeModel.setPrice(price);
        atitudeModel.setType(type);
        atitudeModel.setUrl(this.firebaseService.save(file));
        atitudeModel.setTime(System.currentTimeMillis());
        itemRep.save(atitudeModel);
        return new RedirectView("/");
    }
}
