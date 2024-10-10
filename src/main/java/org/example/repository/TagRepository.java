package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.domaine.Tag;

import java.util.List;

public class TagRepository {

    private EntityManagerFactory emf;
    public TagRepository(){
        this.emf = Persistence.createEntityManagerFactory("myJPAUnit");
    }

    public void save(Tag tag){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = null;

        try{
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(tag);
            transaction.commit();;
        }catch (Exception e){
            if (transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            em.close();
        }
    }

    public List<Tag> getAll(){
        EntityManager em = emf.createEntityManager();
        try{
            return em.createQuery("SELECT t FROM Tag t ORDER BY t.id",Tag.class).getResultList();
        }finally {
            em.close();
        }
    }

    public void delete(Long id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = null;
        try{
            transaction = em.getTransaction();
            transaction.begin();
            Tag tag = em.find(Tag.class,id);
            if (tag !=null){
                em.remove(tag);
            }
            transaction.commit();
        }catch (Exception e){
            if (transaction != null && transaction.isActive()){
                transaction.commit();
            }
            e.printStackTrace();
        }finally {
            em.close();
        }
    }

    public Tag findById(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Tag.class, id);
        } finally {
            em.close();
        }
    }
}
