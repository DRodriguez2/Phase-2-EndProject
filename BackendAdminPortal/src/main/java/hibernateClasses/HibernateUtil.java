package hibernateClasses;

import javax.persistence.RollbackException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	public static Session getSession() {
		return factory.openSession();
	}
	public static <T> boolean checkExists(Class<T> _e, String _key, Session _session) {
		boolean exists;
		if(_session.get((Class<T>) _e, _key) != null) exists = true;
		else exists = false;
		return exists;
	}
	public static <T> boolean insert(SubjectEntity _subject, Session _session) {
		_session.save(_subject);
		try {
			_session.getTransaction().commit();
			return true;
		} catch (RollbackException e) {
			return false;
		}		
	}
}
