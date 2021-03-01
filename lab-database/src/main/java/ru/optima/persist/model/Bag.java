package ru.optima.persist.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Bag {

    private List<BagEquipments> bagEquipments;

    public void clear() {
        bagEquipments.clear();
    }

    public void add(Equipment equipment) {
        for (BagEquipments i : bagEquipments) {
            if (i.getEquipment().getId().equals(equipment.getId())) {
                return;
            }
        }
        bagEquipments.add(new BagEquipments(equipment));
    }
    public void removeByEquipmentId(Long equipmentId) {
        for (int i = 0; i < bagEquipments.size(); i++) {
            if (bagEquipments.get(i).getEquipment().equals(equipmentId)){
                bagEquipments.remove(i);
                return;
            }
        }
    }
}
