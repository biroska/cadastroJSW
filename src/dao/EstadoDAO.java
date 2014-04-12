package dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import sessionFactory.FabricaSessao;
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
public class EstadoDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Estado carregarEstadoPorSigla( String sigla ){

		Criteria criteria = sessionFactory.openSession().createCriteria(Estado.class);
		
		criteria.add( Restrictions.eq("sgEstado", sigla ) );
		
		Estado estado = (Estado) criteria.uniqueResult();
		
		sessionFactory.close();
		
		return estado;
	}
}