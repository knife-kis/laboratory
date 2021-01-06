package ru.optima.persist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.optima.persist.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
