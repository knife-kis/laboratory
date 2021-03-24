package ru.optima.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import ru.optima.repr.EquipmentRepr;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PackageEquipments {
    private List<EquipmentRepr> equipments;

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

    public PackageEquipments() {
    }

    public PackageEquipments(List<EquipmentRepr> equipments) {
        this.equipments = equipments;
    }

    public List<EquipmentRepr> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<EquipmentRepr> equipments) {
        this.equipments = equipments;
    }
}
