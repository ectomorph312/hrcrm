package io.fortylines.hrcrm.service.Impl;

import io.fortylines.hrcrm.entity.Role;
import io.fortylines.hrcrm.repository.RoleRepository;
import io.fortylines.hrcrm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class DefaultRoleService implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public DefaultRoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getById(Long id) {
        return roleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "Role not found"));
    }
}
