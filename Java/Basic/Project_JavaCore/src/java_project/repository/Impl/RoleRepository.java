package java_project.repository.Impl;

import java_project.repository.IRoleRepository;
import java_project.data.CreateData;
import java_project.entity.Role;

import java.util.List;

public class RoleRepository implements IRoleRepository {

    @Override
    public List<Role> findAll() {
        return CreateData.roles;
    }

    @Override
    public Role findRoleById(Long roleId) {
        for (Role role : CreateData.roles) {
            if (role.getId().equals(roleId)) {
                return role;
            }
        }
        return null;
    }
}
