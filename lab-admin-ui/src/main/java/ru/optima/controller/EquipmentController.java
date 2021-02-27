package ru.optima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.optima.controller.repr.EquipmentRepr;
import ru.optima.controller.repr.UserRepr;
import ru.optima.controller.repr.WorkRepr;
import ru.optima.service.EquipmentService;
import ru.optima.service.WorkService;
import ru.optima.warning.NotFoundException;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
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

    @GetMapping("/equipment/{id}/edit")
    public String adminEditWork(Model model, @PathVariable("id") Long id){
        model.addAttribute("edit", true);
        model.addAttribute("activePage", "Equipment");
        model.addAttribute("equipment", equipmentService.findById(id).orElseThrow(NotFoundException::new));
        return "equipment_form";
    }

    @GetMapping("/equipment/create")
    public String adminCreateWork(Model model) {
        model.addAttribute("create", true);
        model.addAttribute("activePage", "Equipment"); // TODO ?
        model.addAttribute("equipment", new EquipmentRepr());
        return "equipment_form";
    }

    @PostMapping("/equipment")
    public String adminUpsertUser(@Valid EquipmentRepr equipmentRepr, Model model, BindingResult bindingResult) {
        model.addAttribute("activePage", "Equipnents");

        if (bindingResult.hasErrors()) {
            return "equipment_form";
        }

        equipmentService.save(equipmentRepr);
        return "redirect:/admin/equipments";
    }

    @DeleteMapping("/equipment/{id}/delete")
    public String adminDeleteWork(Model model, @PathVariable("id") Long id) {
        equipmentService.delete(id);
        return "redirect:/equipments";
    }

}
