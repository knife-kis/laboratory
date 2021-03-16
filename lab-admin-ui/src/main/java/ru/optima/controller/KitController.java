package ru.optima.controller;

import liquibase.pro.packaged.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.optima.persist.model.equipments.Kit;
import ru.optima.persist.repo.EquipmentRepository;
import ru.optima.persist.repo.KitRepository;
import ru.optima.repr.KitRepr;
import ru.optima.service.EquipmentService;
import ru.optima.service.KitService;
import ru.optima.service.KitServiceImpl;
import ru.optima.warning.NotFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

public class KitController {

    private KitServiceImpl kitService;
    private EquipmentService equipmentService;

    @Autowired
    public KitController(KitServiceImpl kitService, EquipmentService equipmentService) {
        this.kitService = kitService;
        this.equipmentService = equipmentService;
    }

    @GetMapping("/equipments_guest/kit/add/{equipmentId}")
    public void addEquipmentToBagById(
            @PathVariable Long equipmentId,
            @Valid Kit kit,
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        kitService.add(equipmentService.findByEId(equipmentId).orElseThrow(NotFoundException::new), kit);
        response.sendRedirect(request.getHeader("referer"));
    }

    @GetMapping("equipments_guest/save/kit")
    public void saveKit(Model model){
        model.addAttribute("create", true);
        model.addAttribute("activePage", "Users");
        model.addAttribute("user", new KitRepr());
    }
}
