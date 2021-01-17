package ru.optima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.optima.controller.repr.EquipmentRepr;
import ru.optima.controller.repr.WorkRepr;
import ru.optima.service.EquipmentService;
import ru.optima.service.WorkService;
import ru.optima.warning.NotFoundException;

@Controller
public class EquipmentController {

    private EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping("/equipments")
    public String adminWorkPage(Model model) {
        model.addAttribute("activePage", "Equipment");
        model.addAttribute("equipment", equipmentService.findAll());
        return "equipments";
    }

    @GetMapping("work/{id}/edit")
    public String adminEditWork(Model model, @PathVariable("id") Long id){
        model.addAttribute("edit", true);
        model.addAttribute("activePage", "Equipment");
        model.addAttribute("equipment", equipmentService.findById(id).orElseThrow(NotFoundException::new));
        return "equipment_form";
    }

    @GetMapping("work/create")
    public String adminCreateWork(Model model) {
        model.addAttribute("create", true);
        model.addAttribute("activePage", "Equipment"); // TODO ?
        model.addAttribute("equipment", new EquipmentRepr());
        return "equipment_form";
    }

    @DeleteMapping("/work/{id}/delete")
    public String adminDeleteWork(Model model, @PathVariable("id") Long id) {
        equipmentService.delete(id);
        return "redirect:/equipments";
    }

}
