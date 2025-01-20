package service.impl;

import dao.RoleDao;
import model.Role;
import org.springframework.stereotype.Service;
import service.RoleService;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDao dao;

    public RoleServiceImpl(RoleDao dao) {
        this.dao = dao;
    }

    @Override
    public Role saveRole(Role role) {
        return dao.saveRole(role);
    }

    @Override
    public Role updateRoleById(Long id, Role role) {
        Role roleToUpdate = dao.getRoleById(id);
        if (roleToUpdate != null) {
            roleToUpdate.setRoleName(role.getRoleName());
            roleToUpdate.setDescription(role.getDescription());
            dao.saveRole(roleToUpdate);
        }
        return roleToUpdate;
    }

    @Override
    public Role getRoleById(Long id) {
        return dao.getRoleById(id);
    }

    @Override
    public List<Role> getAllRoles() {
        return dao.getAllRoles();
    }
}
