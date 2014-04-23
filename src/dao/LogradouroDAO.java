package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import entidade.Logradouro;
import entidade.LogradouroEntity;

@Repository("logradouroDAO")
@Scope( BeanDefinition.SCOPE_PROTOTYPE )
public class LogradouroDAO extends BaseDAO {

	public List<LogradouroEntity> carregarTodosLogradouros(){

		Criteria criteria = getSessionFactory().openSession().createCriteria(Logradouro.class);
		
		List<LogradouroEntity> logradouros = (List<LogradouroEntity>) criteria.list();
		
		getSessionFactory().close();
		
		return logradouros;
	}
}
