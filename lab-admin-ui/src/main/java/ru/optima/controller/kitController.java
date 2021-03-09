package ru.optima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.optima.repr.UserRepr;
import ru.optima.persist.model.equipments.Bag;
import ru.optima.service.UserServiceImpl;

import java.security.Principal;

@Controller
@RequestMapping("/kit")
public class kitController {

    private UserServiceImpl userServiceImpl;
    private Bag bag;

    @Autowired
    public kitController(UserServiceImpl userServiceImpl, Bag bag) {
        this.userServiceImpl = userServiceImpl;
        this.bag = bag;
    }

    @GetMapping("/create")
    public String showBagPage(Principal principal, Model model) {
        UserRepr user = userServiceImpl.findByLastName(principal.getName()).get();
        model.addAttribute("user", user);
        return "kit_form";
    }


}
