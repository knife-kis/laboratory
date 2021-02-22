package ru.optima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/admin")
    public String indexPage(Model model) {
        model.addAttribute("activePage", "None");
        return "index";
    }

}
