package com.example.shop.controller;

import com.example.shop.helpPackeg.AtitudeModelCurent;
import com.example.shop.model.AtitudeModel;
import com.example.shop.repository.ItemRep;
import com.example.shop.repository.OrderRep;
import com.example.shop.services.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/admin/edit")
public class AdminEditController {

    final
    FirebaseService firebaseService;
    final
    ItemRep itemRep;
    OrderRep orderRep;

    public AdminEditController(ItemRep itemRep, FirebaseService firebaseService) {
        this.itemRep = itemRep;
        this.firebaseService = firebaseService;
    }

    @GetMapping("/{id}")
    public String detailInform(@PathVariable int id, Model model){
        AtitudeModel atitudeModel = itemRep.findById(id);
        atitudeModel.setUrl(firebaseService.getUrl(atitudeModel.getUrl()));
        model.addAttribute("item", atitudeModel);
        return "editInfo";
    }

    @PostMapping("/{id}")
    public org.springframework.web.servlet.view.RedirectView editOrder(@PathVariable int id,
                                                                       @RequestParam String name, @RequestParam int price,
                                                                       @RequestParam String disc, @RequestParam String url){
        AtitudeModel atitudeModel = itemRep.findById(id);
        atitudeModel.setName(name);
        atitudeModel.setPrice(price);
        atitudeModel.setDisc(disc);
        atitudeModel.setUrl(url);
        itemRep.save(atitudeModel);
        return new RedirectView("/");
    }
}
