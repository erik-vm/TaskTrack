package dao.impl;

import dao.TaskDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import model.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskDaoImpl implements TaskDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public Task saveTask(Task task) {
        if (task.getTaskId() == null) {
            em.persist(task);
        } else {
            em.merge(task);
        }
        return task;
    }

    @Transactional
    @Override
    public Task getTaskById(Long id) {
        TypedQuery<Task> query = em.createQuery("select t from Task t where t.taskId = :id", Task.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }


    @Override
    public List<Task> getAllTasks() {
        return em.createQuery("select t from Task t", Task.class).getResultList();
    }
}
