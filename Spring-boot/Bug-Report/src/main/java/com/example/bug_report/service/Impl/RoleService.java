package com.example.bug_report.service.Impl;

import com.example.bug_report.entity.Role;
import com.example.bug_report.repository.IRoleRepository;
import com.example.bug_report.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements IRoleService {
    @Autowired private IRoleRepository roleRepository;

    @Override
    public List<Role> findRoleById(long id) {
        return roleRepository.findById(id);
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }
}
