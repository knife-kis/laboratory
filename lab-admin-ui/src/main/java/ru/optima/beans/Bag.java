package ru.optima.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import ru.optima.persist.model.equipments.Equipment;
import ru.optima.repr.EquipmentRepr;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Bag {
    private ArrayList<EquipmentRepr> equipments;

    @PostConstruct
    public void init() {equipments = new ArrayList<>();}

    public void clear(){
        equipments.clear();
    }

    public void add(EquipmentRepr equipment){
        for (EquipmentRepr e : equipments) {
            if (e.getId().equals(equipment.getId())){
                return;
            }
        }
        equipments.add(equipment);
    }

    public Bag() {
    }

    public Bag(ArrayList<EquipmentRepr> equipments) {
        this.equipments = equipments;
    }

    public ArrayList<EquipmentRepr> getEquipments() {
        return equipments;
    }

    public void setEquipments(ArrayList<EquipmentRepr> equipments) {
        this.equipments = equipments;
    }

}
