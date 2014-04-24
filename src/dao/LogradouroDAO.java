package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import entidade.Logradouro;
import entidade.Logradouro;

@Repository("logradouroDAO")
@Scope( BeanDefinition.SCOPE_PROTOTYPE )
public class LogradouroDAO extends BaseDAO {

	public List<Logradouro> carregarTodosLogradouros(){

		Criteria criteria = getSessionFactory().openSession().createCriteria(Logradouro.class);
		
		List<Logradouro> logradouros = (List<Logradouro>) criteria.list();
		
		getSessionFactory().close();
		
		return logradouros;
	}
}
