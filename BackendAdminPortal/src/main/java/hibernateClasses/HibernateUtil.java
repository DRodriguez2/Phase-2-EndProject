package hibernateClasses;

import java.util.List;

import javax.persistence.RollbackException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	private static Session session;
	public static Session getSession() {
		return factory.openSession();
	}
	
	/**
	 * Bad practice, just a quick fix. 
	 * Need to return session.get object without assigning it to an object because 
	 * Hibernate  can't persist on a plain object, it must be an  entity.
	 * Also need to close session after returning object.  
	 * @param <T>
	 * @param _e
	 * @param _key
	 * @return
	 */
	public static <T> Object search(Class<T> _e, String _key) {
		session = getSession();
		session.beginTransaction();
		try {
			return session.get((Class<T>) _e, _key);
		}catch (Exception e) {
			
		}finally {
			session.close();
		}
		return null;
	
	}
	/**
	 * Bad practice see above
	 * @param <T>
	 * @param _e
	 * @param _key
	 * @return
	 */
	public static <T> Object search(Class<T> _e, int _key) {
		session = getSession();
		session.beginTransaction();
		try {
			return session.get((Class<T>) _e, _key);
		}catch (Exception e) {
			
		}finally {
			session.close();
		}
		return null;
	}
	public static boolean insert(Object _e) {
		session = getSession();
		session.beginTransaction();
		session.save(_e);
		try {
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (RollbackException e) {
			session.close();
			return false;
		}		
	}
	public static boolean delete(Object _e) {
		session = getSession();
		session.beginTransaction();
		session.delete(_e);
		try {
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (RollbackException e) {
			session.close();
			return false;
		}
	}
	public static <T> List<?> getAll(String _tableName) {
		String hql = "FROM  " + _tableName;
		List<?> all;
		session = getSession();
		session.beginTransaction();
		all = session.createQuery(hql).list();
		session.close();
		return all;
	}
}
