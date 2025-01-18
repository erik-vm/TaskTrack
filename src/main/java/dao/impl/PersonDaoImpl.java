package dao.impl;

import dao.PersonDao;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import model.Person;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public Person savePerson(Person person) {
        if (person.getPerson_id() == null) {
            person.setCreatedAt(LocalDateTime.now());
            person.setUpdatedAt(LocalDateTime.now());
            em.persist(person);
        } else {
            person.setCreatedAt(LocalDateTime.now());
            em.merge(person);
        }
        return person;
    }

    @Transactional
    @Override
    public Person getPersonById(Long id) {
        TypedQuery<Person> query = em.createQuery("select p from Person p where p.person_id =:id", Person.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Person> getAllPersons() {
        return em.createQuery("select p from Person p where p.deleted = false ", Person.class).getResultList();
    }

    @Transactional
    @Override
    public int deletePersonById(Long id) {
        LocalDateTime currentTimestamp = LocalDateTime.now();

        Query query = em.createQuery("UPDATE Person p SET p.deleted = true, p.deletedAt = :deletedAt WHERE p.person_id = :id");
        query.setParameter("id", id);
        query.setParameter("deletedAt", currentTimestamp);

        return query.executeUpdate();
    }
}
