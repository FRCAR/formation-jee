package com.bigcorp.booking.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

	
public abstract class BaseDao<T> {

	public static final String LIKE_JOKER = "%";

	@PersistenceContext
	protected EntityManager entityManager;
		
	/**
	 * Injects an entityManager. Should be used only for tests.
	 * @param entityManager
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

    public T merge(T object){
        return this.entityManager.merge(object);
    }
    
    public T find(Class<T> clazz, Long id) {
        T entity = this.entityManager.find(clazz, id);
        return entity;
    }
    
    
    public void remove(T object){
        this.entityManager.remove(object);
    }

    public void removeById(Class<T> clazz, Long id) {
        this.entityManager.createQuery("delete " + clazz.getCanonicalName() +  " where id = :id").setParameter("id", id).executeUpdate();
    }
    
    
}
