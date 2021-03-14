package java_project.service.Impl;

import java_project.repository.IRoleRepository;
import java_project.repository.Impl.RoleRepository;
import java_project.entity.Role;
import java_project.service.IRoleService;

import java.util.List;

public class RoleService implements IRoleService {
    private final IRoleRepository roleRepository;

    public RoleService() {
        roleRepository = new RoleRepository();
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findRoleById(Long roleId) {
        return roleRepository.findRoleById(roleId);
    }
}
