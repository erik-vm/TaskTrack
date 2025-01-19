package dao.impl;

import dao.RoleDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import model.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
   private EntityManager em;

    @Override
    public Role saveRole(Role role) {
        return null;
    }

    @Override
    public Role getRoleById(Long id) {
        return null;
    }

    @Override
    public List<Role> getAllRoles() {
        return List.of();
    }
}
