package ru.optima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.optima.repr.KitRepr;
import ru.optima.repr.EquipmentRepr;
import ru.optima.service.EquipmentServiceImpl;
import ru.optima.service.UserServiceImpl;
import ru.optima.warning.NotFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@Controller
public class EquipmentController {

    private EquipmentServiceImpl equipmentService;
    private final UserServiceImpl userServiceImpl;

    public EquipmentController(EquipmentServiceImpl equipmentService, UserServiceImpl userServiceImpl) {
        this.equipmentService = equipmentService;
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/admin/equipments")
    public String adminEquipmentsPage(Model model) {
        model.addAttribute("activePage", "Equipments");
        model.addAttribute("equipments", equipmentService.findAll());
        return "equipments";
    }

    @GetMapping("/admin/equipment/{id}/edit")
    public String adminEditEquipment(Model model, @PathVariable("id") Long id) {
        model.addAttribute("edit", true);
        model.addAttribute("activePage", "Equipment");
        model.addAttribute("equipment", equipmentService.findById(id).orElseThrow(NotFoundException::new));
        return "equipment_form";
    }

    @GetMapping("/admin/equipment/create")
    public String adminCreateEquipment(Model model) {
        model.addAttribute("create", true);
        model.addAttribute("activePage", "Equipments"); // TODO ?
        model.addAttribute("equipment", new EquipmentRepr());
        return "equipment_form";
    }

    @PostMapping("/admin/equipment")
    public String adminUpsertEquipment(@Valid EquipmentRepr equipment, Model model, BindingResult bindingResult) {
        model.addAttribute("activePage", "Equipments");

        if (bindingResult.hasErrors()) {
            return "equipment_form";
        }

        equipmentService.save(equipment);
        return "redirect:/admin/equipments";
    }

    @DeleteMapping("/admin/equipment/{id}/delete")
    public String adminDeleteEquipment(Model model, @PathVariable("id") Long id) {
        equipmentService.delete(id);
        return "redirect:/admin/equipments";
    }

    @GetMapping("/equipments_guest")
    public String EquipmentsPage(Model model) {
        model.addAttribute("activePage", "Equipments");
        model.addAttribute("equipments", equipmentService.findAll());
        return "equipments_guest";
    }

}
