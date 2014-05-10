package daoInterf;

import org.springframework.stereotype.Component;

import entidade.Cidade;
import generic.GenericDAO;

@Component("cidadeInterfDAO")
public interface CidadeInterfDAO extends GenericDAO<Cidade> {
	
	public void addCidade(Cidade p);

}