package ru.optima.persist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.optima.persist.model.Equipment;
import ru.optima.persist.model.Work;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    Work findById(long id);
}
