package com.bigcorp.persister.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bigcorp.persister.model.BigCorpUser;


public class UserDao {

    public void persist(BigCorpUser user){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersisterPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(user);
        tx.commit();
        em.close();
    }

    
}
