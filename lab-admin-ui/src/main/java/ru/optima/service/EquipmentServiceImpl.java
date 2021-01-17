package ru.optima.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.optima.controller.repr.EquipmentRepr;
import ru.optima.controller.repr.WorkRepr;
import ru.optima.persist.model.Equipment;
import ru.optima.persist.model.Work;
import ru.optima.persist.repo.EquipmentRepository;
import ru.optima.persist.repo.WorkRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class EquipmentServiceImpl implements EquipmentService, Serializable {

    private EquipmentRepository equipmentRepository;

    @Autowired
    public EquipmentServiceImpl(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public void save(EquipmentRepr equipmentRepr) {
        Equipment equipment = new Equipment();
        equipment.setId(equipmentRepr.getId());
        equipment.setName(equipmentRepr.getName());
        equipment.setInventoruNumber(equipmentRepr.getInventoruNumber());
        equipment.setVerificationNumber(equipmentRepr.getVerificationNumber());
        equipment.setVerificationDate(equipmentRepr.getVerificationDate());
        equipment.setVerificationDateEnd(equipmentRepr.getVerificationDateEnd());
        equipment.setUsers(equipmentRepr.getUsers());
        equipmentRepository.save(equipment);
    }

    @Override
    public List<EquipmentRepr> findAll() {
        return equipmentRepository.findAll().stream()
                .map(EquipmentRepr::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<EquipmentRepr> findById(Long id) {
        return equipmentRepository.findById(id).map(EquipmentRepr::new);
    }

    @Override
    public void delete(Long id) {

    }

}
