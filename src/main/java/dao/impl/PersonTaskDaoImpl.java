package dao.impl;

import dao.PersonTaskDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import model.PersonTask;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonTaskDaoImpl implements PersonTaskDao {

    @PersistenceContext
    private EntityManager em;


    @Transactional
    @Override
    public PersonTask savePersonTask(PersonTask personTask) {
        if (personTask.getPersonTaskId() == null) {
            em.persist(personTask);
        } else {
            em.merge(personTask);
        }
        return personTask;
    }

    @Transactional
    @Override
    public PersonTask getPersonTaskById(Long id) {
        TypedQuery<PersonTask> query = em.createQuery("select pt from PersonTask pt where pt.personTaskId = :id", PersonTask.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<PersonTask> getAllPersonTasks() {
        return em.createQuery("select pt from PersonTask pt", PersonTask.class).getResultList();
    }
}
