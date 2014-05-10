package dao;

import daoInterf.LoginInterfDAO;
import entidade.Usuario;
import generic.AbstractDAO;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
 
@Repository
@Scope("prototype")
public class LoginDAO  extends AbstractDAO<Usuario> implements LoginInterfDAO {

	public LoginDAO() {
        super(Usuario.class);
	}
	
	public boolean loginUsuario( String usuario, String senha ){
		
		if ( ( "admin".equalsIgnoreCase( usuario ) && "senha".equalsIgnoreCase( senha ) ) ||
			 ( "biroska".equalsIgnoreCase( usuario ) && "2904pior".equalsIgnoreCase( senha ) ) ){
			return true;
		}
		return false;
	}
}