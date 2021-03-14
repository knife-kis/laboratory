package ru.optima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.optima.beans.Bag;
import ru.optima.service.EquipmentServiceImpl;
import ru.optima.warning.NotFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
public class BagController {

    private Bag bag;
    private EquipmentServiceImpl equipmentService;

    @Autowired
    public BagController(Bag bag, EquipmentServiceImpl service) {
        this.bag = bag;
        this.equipmentService = service;
    }

    @GetMapping("/bag")
    public String showKits(Model model){
        model.addAttribute("bag", bag);
        return "bag";
    }

    @GetMapping("/bag/add/{id}")
    public void addEquipmentToBagById(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        bag.add(equipmentService.findById(id).orElseThrow(NotFoundException::new));
        response.sendRedirect(request.getHeader("referer"));
    }
}
