package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.domaine.Task;

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
        EntityManager em =emf.createEntityManager();
        try{
            return em.createQuery("SELECT t FROM Task t ORDER BY t.id", Task.class).getResultList();
        }finally {
            em.close();
        }
    }


    public Task findById(Long id){
        EntityManager em =emf.createEntityManager();
        try{
            return em.find(Task.class, id);
        }finally {
            em.close();
        }
    }

    public void delete(Long id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = null;
        try{
            transaction =em.getTransaction();
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
        try{
            transaction = em.getTransaction();
            transaction.begin();
            em.merge(task);
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
}