package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.domaine.Task;
import org.example.domaine.TaskStatus;

import java.util.List;

public class TaskRepository {

    private EntityManagerFactory emf;

    public TaskRepository() {
        this.emf = Persistence.createEntityManagerFactory("myJPAUnit");
    }

    public void save(Task task){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = null;
        try{
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(task);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            em.close();
        }
    }

    public List<Task> getAll(){
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT DISTINCT t FROM Task t LEFT JOIN FETCH t.tags ORDER BY t.id", Task.class).getResultList();
        } finally {
            em.close();
        }
    }

    public Task findById(Long id){
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT t FROM Task t LEFT JOIN FETCH t.tags WHERE t.id = :id", Task.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } finally {
            em.close();
        }
    }

    public void delete(Long id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = null;
        try{
            transaction = em.getTransaction();
            transaction.begin();
            Task task = em.find(Task.class, id);
            if(task != null){
                em.remove(task);
            }
            transaction.commit();
        }catch (Exception e){
            if (transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            em.close();
        }
    }

    public void update(Task task){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            Task managedTask = em.find(Task.class, task.getId());
            managedTask.setTitle(task.getTitle());
            managedTask.setDescription(task.getDescription());
            managedTask.setStatus(task.getStatus());
            managedTask.setStartDate(task.getStartDate());
            managedTask.setDueDate(task.getDueDate());
            managedTask.setAssignee(task.getAssignee());
            managedTask.setTags(task.getTags());
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void updateStatus(Long taskId, TaskStatus status) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            Task task = em.find(Task.class, taskId);
            if (task != null) {
                task.setStatus(status);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();

        }
    }
}