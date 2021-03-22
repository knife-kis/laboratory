package ru.optima.controller;

import liquibase.pro.packaged.E;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.optima.persist.model.equipments.Equipment;
import ru.optima.persist.model.equipments.Kit;
import ru.optima.persist.repo.EquipmentRepository;
import ru.optima.repr.KitRepr;
import ru.optima.service.EquipmentService;
import ru.optima.service.EquipmentServiceImpl;
import ru.optima.service.KitServiceImpl;
import ru.optima.warning.NotFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Optional;

@Controller
public class KitController {

    private KitServiceImpl kitService;
    private EquipmentServiceImpl equipmentService;

    @Autowired
    public KitController(KitServiceImpl kitService, EquipmentServiceImpl equipmentService) {
        this.kitService = kitService;
        this.equipmentService = equipmentService;
    }

    @GetMapping("/equipments_guest/kit/add/{equipmentId}")
    public String addEquipmentToBagById(Model model,
            @PathVariable Long equipmentId, @Valid Kit kit) {
        Equipment equipment = equipmentService.findByEId(equipmentId);
        kitService.addEquipment(equipment, kit);
        return "redirect:/equipments_guest";
    }

    @GetMapping("equipments_guest/save/kit")
    public void saveKit(Model model){
        model.addAttribute("create", true);
        model.addAttribute("activePage", "Users");
        model.addAttribute("user", new KitRepr());
    }
}
