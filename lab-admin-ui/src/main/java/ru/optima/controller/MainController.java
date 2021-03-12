package ru.optima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.optima.persist.model.Role;
import ru.optima.service.UserServiceImpl;

@Controller
public class MainController {
    private final UserServiceImpl userService;

    @Autowired
    public MainController(UserServiceImpl userService) {
        this.userService = userService;
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @Secured("ROLE_ADMIN")
    @RequestMapping("/admin")
    public String indexPage(Model model) {
        model.addAttribute("activePage", "None");
        return "index";
    }

//    @PreAuthorize("hasRole('ROLE_GUEST')")
//    @Secured("ROLE_GUEST")
    @RequestMapping("/")
    public String indexPageGuest(Model model) {
        model.addAttribute("activePage", "None");
        return "index_guest";
    }

}
