package org.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class GeneralDao 
{

	protected EntityManager getEntityManager() {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-sqlite-jpa");
	    EntityManager ecm = emf.createEntityManager(); 
	    return ecm;
	} 
	
}
