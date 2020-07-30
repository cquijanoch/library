package org.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public abstract class GeneralDao 
{
	private EntityManager em = null;
	
	protected EntityManager getEntityManager()
	{
		EntityManagerFactory emf  = Persistence.createEntityManagerFactory("pu-sqlite-jpa");
		em = emf.createEntityManager();
	    return em;
	} 
	
}
