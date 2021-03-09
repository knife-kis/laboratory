package ru.optima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.optima.repr.EquipmentRepr;
import ru.optima.service.EquipmentService;
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
    public String adminEquipmentsPage(Model model) {
        model.addAttribute("activePage", "Equipments");
        model.addAttribute("equipments", equipmentService.findAll());
        return "equipments";
    }

    @GetMapping("/equipment/{id}/edit")
    public String adminEditEquipment(Model model, @PathVariable("id") Long id) {
        model.addAttribute("edit", true);
        model.addAttribute("activePage", "Equipment");
        model.addAttribute("equipment", equipmentService.findById(id).orElseThrow(NotFoundException::new));
        return "equipment_form";
    }

    @GetMapping("/equipment/create")
    public String adminCreateEquipment(Model model) {
        model.addAttribute("create", true);
        model.addAttribute("activePage", "Equipments"); // TODO ?
        model.addAttribute("equipment", new EquipmentRepr());
        return "equipment_form";
    }

    @PostMapping("/equipment")
    public String adminUpsertEquipment(@Valid EquipmentRepr equipment, Model model, BindingResult bindingResult) {
        model.addAttribute("activePage", "Equipments");

        if (bindingResult.hasErrors()) {
            return "equipment_form";
        }

        equipmentService.save(equipment);
        return "redirect:/admin/equipments";
    }

    @DeleteMapping("/equipment/{id}/delete")
    public String adminDeleteEquipment(Model model, @PathVariable("id") Long id) {
        equipmentService.delete(id);
        return "redirect:/admin/equipments";
    }

}
