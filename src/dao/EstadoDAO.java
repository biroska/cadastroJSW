package dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import entidade.Estado;
 
/*@Repository("estadoDAO")
public class EstadoDAO extends FabricaSessao {
	
	public Estado carregarEstadoPorSigla( String sigla ){
		
		Session session = super.getSessionFactory().openSession();
		
		Criteria criteria = session.createCriteria(Estado.class);
		
		criteria.add( Restrictions.eq("sgEstado", sigla ) );
		
		Estado estado = (Estado) criteria.uniqueResult();
		
		super.getSessionFactory().close();
		
		return estado;
	}*/


@Repository("estadoDAO")
@Scope("prototype")
public class EstadoDAO extends BaseDAO {
	
//	@Autowired
//	private SessionFactory sessionFactory;
	
	public void addEstado(Estado e){
		Session session = getSessionFactory().openSession();
		session.save(e);
		session.close();
	}
	
	public Estado carregarEstadoPorSigla( String sigla ){

		Criteria criteria = getSessionFactory().openSession().createCriteria(Estado.class);
		
		criteria.add( Restrictions.eq("sgEstado", sigla ) );
		
		Estado estado = (Estado) criteria.uniqueResult();
		
		getSessionFactory().close();
		
		return estado;
	}
}