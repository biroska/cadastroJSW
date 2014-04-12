package dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
 
@Repository
@Scope("prototype")
public class LoginDAO {
	
	public boolean loginUsuario( String usuario, String senha ){
		
		if ( ( "admin".equalsIgnoreCase( usuario ) && "senha".equalsIgnoreCase( senha ) ) ||
			 ( "biroska".equalsIgnoreCase( usuario ) && "2904pior".equalsIgnoreCase( senha ) ) ){
			return true;
		}
		return false;
	}
}