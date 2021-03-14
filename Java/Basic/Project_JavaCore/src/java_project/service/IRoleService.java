package java_project.service;

import java_project.entity.Role;

import java.util.List;

public interface IRoleService {
    List<Role> findAll();
    Role findRoleById(Long roleId);
}
