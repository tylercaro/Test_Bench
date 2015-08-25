package com.eintern.jsf.login;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sf;
	

	public static void setSf(SessionFactory sf) {
		HibernateUtil.sf = sf;
	}

	static {
		Configuration cfg = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(cfg.getProperties());
		setSf(cfg.buildSessionFactory(builder.build()));
		

	}

	public static SessionFactory getSessionFactory() {

		return sf;
	}
}
