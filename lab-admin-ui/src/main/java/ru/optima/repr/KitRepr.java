package ru.optima.repr;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import ru.optima.persist.model.User;
import ru.optima.persist.model.equipments.Equipment;
import ru.optima.persist.model.equipments.Kit;
import ru.optima.repr.EquipmentRepr;

import javax.annotation.PostConstruct;
import java.util.*;

public class KitRepr {

    private Long id;
    private List<Equipment> equipments;
    private String name;
    private int count = 1;

    public KitRepr() {
    }

    public KitRepr(Kit kit) {
        this.id = kit.getId();
        this.equipments = kit.getEquipments();
        this.name = "Комплет №:" + count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }
}
