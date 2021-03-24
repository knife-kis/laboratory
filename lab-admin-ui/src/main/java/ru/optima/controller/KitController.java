package ru.optima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.optima.repr.KitRepr;
import ru.optima.service.EquipmentServiceImpl;
import ru.optima.service.KitServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class KitController {

    private KitServiceImpl kitService;
    private EquipmentServiceImpl equipmentService;

    @Autowired
    public KitController(KitServiceImpl kitService, EquipmentServiceImpl equipmentService) {
        this.kitService = kitService;
        this.equipmentService = equipmentService;
    }

    @PostMapping("/equipments_guest/create/kit")
    public String addPackageEquipmentToKit(Model model) {
        model.addAttribute("create", true);
        model.addAttribute("activePage", "Users");
        model.addAttribute("kit", new KitRepr());
        return "redirect:/equipments_guest";
    }

    @GetMapping("equipments_guest/save/kit")
    public void saveKit(Model model){
        model.addAttribute("create", true);
        model.addAttribute("activePage", "Users");
        model.addAttribute("user", new KitRepr());
    }
}
