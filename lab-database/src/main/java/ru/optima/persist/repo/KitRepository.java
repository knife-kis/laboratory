package ru.optima.persist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.optima.persist.model.equipments.Kit;

import java.util.Optional;

public interface KitRepository extends JpaRepository<Kit, Long> {
    Optional<Kit> findById(Long id);
}
