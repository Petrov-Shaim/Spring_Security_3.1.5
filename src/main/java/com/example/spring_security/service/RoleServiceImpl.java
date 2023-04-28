package com.example.spring_security.service;

import com.example.spring_security.dao.RoleRepository;
import com.example.spring_security.entity.Role;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class RoleServiceImpl implements RoleService{
    private final RoleRepository roleRepository;

    private final EntityManager entityManager;

    public RoleServiceImpl(RoleRepository roleRepository, EntityManager entityManager) {
        this.roleRepository = roleRepository;
        this.entityManager = entityManager;
    }
    @Override
    public void saveRole(Role role) {
        roleRepository.save(role);
    }
}
