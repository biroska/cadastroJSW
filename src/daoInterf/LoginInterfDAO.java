package daoInterf;

import entidade.Usuario;
import generic.GenericDAO;

import org.springframework.stereotype.Component;

@Component("loginInterfDAO")
public interface LoginInterfDAO extends GenericDAO<Usuario> {
	
}