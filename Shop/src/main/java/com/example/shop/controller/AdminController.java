package com.example.shop.controller;

import com.example.shop.model.AtitudeModel;
import com.example.shop.model.OrderModel;
import com.example.shop.repository.ItemRep;
import com.example.shop.repository.OrderRep;
import com.example.shop.services.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    final
    FirebaseService firebaseService;

    final
    ItemRep itemRep;

    final
    OrderRep orderRep;

    public AdminController(OrderRep orderRep, ItemRep itemRep, FirebaseService firebaseService) {
        this.orderRep = orderRep;
        this.itemRep = itemRep;
        this.firebaseService = firebaseService;
    }

    @GetMapping
    public String menuAdmin(){
        return "AdminMenu";
    }

    @GetMapping("/req")
    public String requestAtitude(Model model){
        List<OrderModel> listOrder = orderRep.findAll();
        model.addAttribute("order", listOrder);
        return "Request";
    }

    @GetMapping("/edit")
    public String edit (Model model){
        List<AtitudeModel> listAtitude = itemRep.findAll();
        listAtitude.stream().forEach(i -> i.setUrl(firebaseService.getUrl(i.getUrl())));
        model.addAttribute("items", listAtitude);
        return "Edit";
    }
}
