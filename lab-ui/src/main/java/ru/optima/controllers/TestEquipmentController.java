package ru.optima.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.optima.service.EquipmentService;

@Controller
public class TestEquipmentController {

    private EquipmentService equipmentService;

    @Autowired
    public TestEquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping("/equipments_guest")
    public String EquipmentsPage(Model model) {
        model.addAttribute("activePage", "Equipments");
        model.addAttribute("equipments", equipmentService.findAll());
        return "equipments_guest";
    }
}
