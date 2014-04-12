package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import entidade.Cidade;

@Repository("cidadeDAO")
@Scope("prototype")
public class CidadeDAO extends BaseDAO {

//	@Autowired
//	private SessionFactory sessionFactory;
//
//	public void setSessionFactory(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}

	public void addCidade(Cidade p) {
		Session session = getSessionFactory().openSession();
		session.save(p);
		session.close();
	}

}