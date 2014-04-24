package dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import entidade.Estado;
 
@Repository("estadoDAO")
@Scope("prototype")
public class EstadoDAO extends BaseDAO {
	
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