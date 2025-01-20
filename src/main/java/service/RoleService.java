package service;

import model.Role;

import java.util.List;

public interface RoleService {

    Role saveRole(Role role);

    Role updateRoleById(Long id, Role role);

    Role getRoleById(Long id);

    List<Role> getAllRoles();
}
