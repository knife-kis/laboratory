package ru.optima.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.optima.persist.model.Role;
import ru.optima.persist.repo.RoleRepository;

import java.util.List;

@Service
public class RoleService {
    private RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles() {return roleRepository.findAll();}

    public List<Role> getRolesByIds(List<Long> ids) {
        return roleRepository.findAllById(ids);
    }
}
