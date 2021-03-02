package ru.optima.service;

import org.springframework.stereotype.Service;
import ru.optima.persist.model.Role;
import ru.optima.persist.repo.RoleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Optional<Role> findByName(String name) {
        return roleRepository.findOneByName(name);
    }
}
