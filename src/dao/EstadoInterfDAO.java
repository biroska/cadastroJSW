package dao;

import entidade.Estado;
import generic.GenericDAO;

import org.springframework.stereotype.Component;

@Component("estadoInterfDAO")
public interface EstadoInterfDAO extends GenericDAO<Estado> {
	
	public Estado carregarEstadoPorSigla( String sigla );

}
