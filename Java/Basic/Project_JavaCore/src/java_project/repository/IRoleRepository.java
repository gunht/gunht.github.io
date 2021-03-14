package java_project.repository;

import java_project.entity.Role;

import java.util.List;

public interface IRoleRepository {
    List<Role> findAll();
    Role findRoleById(Long roleId);
}
