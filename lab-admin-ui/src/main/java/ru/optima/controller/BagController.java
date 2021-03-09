package ru.optima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.optima.persist.model.equipments.Bag;

@Controller
@RequestMapping("/bag")
public class BagController {

    private Bag bag;

    @Autowired
    public BagController(Bag bag) {
        this.bag = bag;
    }

    @GetMapping
    public String showBagPage(Model model) {
        model.addAttribute("bag", bag);
        return "bag";
    }

}
