package dao;

import model.Role;

import java.util.List;

public interface RoleDao {

    Role saveRole(Role role);

    Role getRoleById(Long id);

    List<Role> getAllRoles();
}
