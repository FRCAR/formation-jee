package com.bigcorp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Assert;
import org.junit.Test;

import com.bigcorp.persister.entity.Message;

public class MessageDaoTest {

    @Test
    public void testSave() {
        Message message = new Message();
        message.setText("Hello World!");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersisterPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(message);
        tx.commit();
        em.close();

        Assert.assertNotNull(message.getId());
        em = emf.createEntityManager();
        Message messageFromDb = em.find(Message.class, message.getId());
        Assert.assertEquals(message.getId(), messageFromDb.getId());
        Assert.assertEquals(message.getText(), messageFromDb.getText());
        em.close();

    }

}
