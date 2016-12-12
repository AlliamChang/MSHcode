package daoImpl;

import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public final class HibernateUtil {
	private static Configuration cfg;
	private static SessionFactory sessionFactory = null;

	private HibernateUtil() {
	}

	static {
		cfg = new AnnotationConfiguration();
		cfg.configure();
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			sessionFactory = cfg.configure().buildSessionFactory();
		}
		return sessionFactory;
	}

	public static Session getSession() {
		return getSessionFactory().openSession();
	}

}
