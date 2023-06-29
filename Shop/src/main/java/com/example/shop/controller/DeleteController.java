package com.example.shop.controller;

import com.example.shop.repository.ItemRep;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/admin/delete")
public class DeleteController {

    final
    ItemRep itemRep;

    public DeleteController(ItemRep itemRep) {
        this.itemRep = itemRep;
    }

    @GetMapping("/{id}")
    public RedirectView deleteAtitude(@PathVariable int id){
        itemRep.deleteById(id);
        return new RedirectView("/admin");
    }
}
