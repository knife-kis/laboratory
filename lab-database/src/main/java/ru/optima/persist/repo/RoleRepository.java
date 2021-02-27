package ru.optima.persist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.optima.persist.model.Role;
import ru.optima.persist.model.User;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

//    Optional<Role> findRoleByName(String name);


}
