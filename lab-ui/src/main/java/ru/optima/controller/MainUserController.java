package ru.optima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class MainUserController {

    public String indexPage(Model model) {
        model.addAttribute("activePage","None");
        return "index";
    }
}

