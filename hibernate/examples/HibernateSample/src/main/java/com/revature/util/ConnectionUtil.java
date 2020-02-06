package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class ConnectionUtil {
	/** You can have a different file name than hibernate.cfg.xml
	 * passing a paremter to the configure method.
	*/
	private static SessionFactory sessionFactory =
			new Configuration().configure().buildSessionFactory();
	
	public static Session getSession() {
		return sessionFactory.openSession();
	}
}
