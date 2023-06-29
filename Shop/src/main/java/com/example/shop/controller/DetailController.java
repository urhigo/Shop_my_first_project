package com.example.shop.controller;

import com.example.shop.helpPackeg.AtitudeModelCurent;
import com.example.shop.model.AtitudeModel;
import com.example.shop.model.OrderModel;
import com.example.shop.repository.ItemRep;
import com.example.shop.repository.OrderRep;
import com.example.shop.services.CurentyService;
import com.example.shop.services.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/item")
public class DetailController{

    final
    FirebaseService firebaseService;
    final
    ItemRep itemRep;

    public DetailController(ItemRep itemRep, CurentyService curentyService, OrderRep orderRep, FirebaseService firebaseService) {
        this.itemRep = itemRep;
        this.curentyService = curentyService;
        this.orderRep = orderRep;
        this.firebaseService = firebaseService;
    }

    final
    CurentyService curentyService;

    final
    OrderRep orderRep;


    @GetMapping("/{id}")
    public String detailInform(@PathVariable int id, Model model){
        AtitudeModel atitudeModel = itemRep.findById(id);
        AtitudeModelCurent atitudeModelCurent = new AtitudeModelCurent(atitudeModel);
        atitudeModelCurent.setUsdPrice(curentyService.getUsdPrice(atitudeModel.getPrice()));
        atitudeModelCurent.setEurPrice(curentyService.getEurPrice(atitudeModel.getPrice()));
        atitudeModelCurent.setUrl(firebaseService.getUrl(atitudeModelCurent.getUrl()));
        model.addAttribute("item", atitudeModelCurent);
        return "DetailInf";
    }

    @PostMapping("/{id}")
    public RedirectView newOrder(@PathVariable int id,
                                 @RequestParam String name, @RequestParam String telephoneNumber){
        OrderModel orderModel = new OrderModel();
        orderModel.setNameUser(name);
        orderModel.setTelephoneNumber(telephoneNumber);
        orderModel.setIdOrder(id);
        orderRep.save(orderModel);
        return new RedirectView("/");
    }
}
