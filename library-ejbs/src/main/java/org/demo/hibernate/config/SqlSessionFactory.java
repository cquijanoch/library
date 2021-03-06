package org.demo.hibernate.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SqlSessionFactory {
	protected static final SessionFactory sessionFactory;
	 
    static {
    	try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(ssrb.build());
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
