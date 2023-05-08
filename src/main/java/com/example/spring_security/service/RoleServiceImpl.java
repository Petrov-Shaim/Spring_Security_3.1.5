package com.example.spring_security.service;

import com.example.spring_security.repositories.RoleRepository;
import com.example.spring_security.models.Role;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{
    private final RoleRepository roleRepository;
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    @Override
    public void saveRole(Role role) {
        roleRepository.save(role);
    }
}
