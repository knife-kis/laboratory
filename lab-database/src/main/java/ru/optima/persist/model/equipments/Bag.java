package ru.optima.persist.model.equipments;

import org.hibernate.annotations.Cascade;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Bag {

    private List<Equipment> equipments;

    @PostConstruct
    public void init() {
        equipments = new ArrayList<Equipment>() {
        };
    }

    public void clear() {
        equipments.clear();
    }

    public void add(Equipment equipment) {
        equipments.add(equipment);
    }
    public void removeByEquipmentId(int equipmentId) {
        equipments.remove(equipmentId);
    }

    public Bag() {
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }
}
