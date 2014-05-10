package daoInterf;

import org.hibernate.SessionFactory;

public interface BaseInterfDAO {
	
	public void setSessionFactory(SessionFactory sessionFactory);

	public SessionFactory getSessionFactory();
}
