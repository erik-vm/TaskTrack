package dao.impl;

import dao.RoleDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import model.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public Role saveRole(Role role) {
        if (role.getRoleId() == null) {
            em.persist(role);
        } else {
            em.merge(role);
        }
        return role;
    }

    @Transactional
    @Override
    public Role getRoleById(Long id) {
        TypedQuery<Role> query = em.createQuery("select r from Role r where r.roleId = :id", Role.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Role> getAllRoles() {
        return em.createQuery("select r from Role r", Role.class).getResultList();
    }
}
