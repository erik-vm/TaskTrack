package dao.impl;

import dao.PersonDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import model.Person;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDaoImpl implements PersonDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public Person savePerson(Person person) {
        if (person.getPerson_id() == null) {
            em.persist(person);
        } else {
            em.merge(person);
        }
        return person;
    }

    @Transactional
    @Override
    public Person getPersonById(Long id) {
        TypedQuery<Person> query = em.createQuery("select p from Person p where p.person_id =:id", Person.class);
        query.setParameter("id", id);

        return query.getSingleResult();
    }
}
