package daoInterf;

import java.util.List;

import entidade.Logradouro;
import generic.GenericDAO;

import org.springframework.stereotype.Component;

@Component("logradouroInterfDAO")
public interface LogradouroInterfDAO  extends GenericDAO<Logradouro> {

	public List<Logradouro> carregarTodosLogradouros();
	
}
