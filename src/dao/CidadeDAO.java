package dao;

import daoInterf.CidadeInterfDAO;
import entidade.Cidade;
import entidade.Estado;
import generic.AbstractDAO;

import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository("cidadeDAO")
@Scope("prototype")
//public class CidadeDAO extends BaseDAO {
public class CidadeDAO extends AbstractDAO<Cidade> implements CidadeInterfDAO {

	public CidadeDAO() {
	    super(Cidade.class);
	}

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