package uteis;

import java.lang.reflect.Field;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.mysql.jdbc.StringUtils;

public class ValidacaoGenerica {

	public static boolean validarObrigatorio(Object obj, String msg ) {
		
		boolean retorno = true;

		Class myObj = obj.getClass();
		
		if ( myObj.getName().contains("String") ){

			if ( "".equals( obj ) || StringUtils.isNullOrEmpty( (String) obj ) ){
				retorno = false;
				System.out.println("ValidacaoGenerica.validar()");
				
				FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                msg,
                                msg));
			}
		}
		return retorno;
	}
}