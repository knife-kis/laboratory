package ru.optima.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.optima.persist.model.User;
import ru.optima.persist.model.equipments.Equipment;
import ru.optima.persist.model.equipments.Kit;
import ru.optima.persist.repo.EquipmentRepository;
import ru.optima.persist.repo.KitRepository;
import ru.optima.repr.EquipmentRepr;
import ru.optima.repr.KitRepr;
import ru.optima.repr.UserRepr;
import ru.optima.warning.UserNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class KitServiceImpl implements KitService {

    private KitRepository kitRepository;
    private EquipmentRepository equipmentRepository;

    @Autowired
    public void setUserRepository(KitRepository userRepository) {
        this.kitRepository = userRepository;
    }


    public void save(KitRepr kitRepr) {
        Kit kit = new Kit();
        kit.setId(kitRepr.getId());
        kit.setEquipments(kitRepr.getEquipments());
        kit.setUser(kitRepr.getUser());
        kitRepository.save(kit);
    }

    public void add(Equipment equipment, Kit kit){
        List<Equipment> equipments = equipmentRepository.findAll();
        for (Equipment e : equipments) {
            if (e.getId().equals(equipment.getId())){
                return;
            }
        }
        equipments.add(equipment);
        kit.setEquipments(equipments);
        kitRepository.save(kit);
    }

    @Override
    public List<KitRepr> findAll() {
        return kitRepository.findAll().stream()
                .map(KitRepr::new)
                .collect(Collectors.toList());
    }

    @Override
    public Kit findById(Long id) {
        return kitRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Kit by id " + id + " was not found"));
    }

    public void delete(Long id) {
        kitRepository.deleteById(id);
    }

    public Kit updateUser(Kit kit) {
        return kitRepository.save(kit);
    }
}
