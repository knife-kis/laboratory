package ru.optima.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import ru.optima.persist.model.equipments.Equipment;
import ru.optima.repr.EquipmentRepr;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Bag {
    private List<EquipmentRepr> equipments;

    @PostConstruct
    public void init() {equipments = new ArrayList<>();}

    public void clear(){
        equipments.clear();
    }

    public void add(EquipmentRepr equipment){
        System.out.println("sefsefseffffffffffffffffffffffffff " + equipment.getName());
        equipments.add(equipment);
//        for (EquipmentRepr e: equipments
//        ) {
//            System.out.println("sefsefseffffffffffffffffffffffffff " + e.getName());
//            System.out.println("sefsefseffffffffffffffffffffffffff " + e.getName());
////            if (e.getId().equals(equipment.getId())){
////                return;
////            }
//            equipments.add(new EquipmentRepr());
//        }
    }
    public void removeByEquipmentId(Long equipmentId){
        for (int i = 0; i < equipments.size(); i++) {
            if (equipments.get(i).getId().equals(equipmentId)){
                equipments.remove(i);
                return;
            }
        }
    }

    public Bag() {
    }

    public Bag(List<EquipmentRepr> equipments) {
        this.equipments = equipments;
    }

    public List<EquipmentRepr> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<EquipmentRepr> equipments) {
        this.equipments = equipments;
    }

}
