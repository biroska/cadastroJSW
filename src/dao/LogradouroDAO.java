package dao;

import daoInterf.LogradouroInterfDAO;
import entidade.Logradouro;
import generic.AbstractDAO;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository("logradouroDAO")
@Scope( BeanDefinition.SCOPE_PROTOTYPE )
public class LogradouroDAO  extends AbstractDAO<Logradouro> implements LogradouroInterfDAO {

	public LogradouroDAO() {
        super(Logradouro.class);
	}

	public List<Logradouro> carregarTodosLogradouros(){

		Criteria criteria = getCurrentSession().createCriteria(Logradouro.class);
		
		List<Logradouro> logradouros = (List<Logradouro>) criteria.list();
		
		return logradouros;
	}
}
