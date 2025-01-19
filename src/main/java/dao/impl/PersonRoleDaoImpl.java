package dao.impl;

import dao.PersonRoleDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import model.PersonRole;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRoleDaoImpl implements PersonRoleDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public PersonRole savePersonRole(PersonRole personRole) {
        if (personRole.getPersonRoleId() == null) {
            em.persist(personRole);
        } else {
            em.merge(personRole);
        }
        return personRole;
    }

    @Override
    public PersonRole getPersonRoleById(Long id) {
        TypedQuery<PersonRole> query = em.createQuery("select pr from PersonRole pr where pr.personRoleId = :id", PersonRole.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<PersonRole> getAllPersonRoles() {
        return em.createQuery("select pr from PersonRole pr", PersonRole.class).getResultList();
    }
}
