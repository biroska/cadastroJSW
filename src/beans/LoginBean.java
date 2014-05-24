package beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import daoInterf.LoginInterfDAO;
import entidade.Usuario;
import facade.Facade;
 
@Component("loginMB")
@ManagedBean(name="loginMB")
@SessionScoped
public class LoginBean {
    
    @Autowired
    Usuario user;
    
    @Autowired
    LoginInterfDAO dao;
    
    @Autowired
    Facade facade;
     
    private boolean erro = false;
    private boolean utilizaWebService = false;
     
    public String login() {
        
        System.out.println("RegistrationUserBean:: Registering user " + user.getDsLogin() + " " + user.getDsSenha() + " - utilizaWebService: " + utilizaWebService );
        
// Seta na sessao a opçao de usar o webservice ou não        
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("utilizaWebService", utilizaWebService );
        
        if ( facade.loginUsuario( user.getDsLogin(), user.getDsSenha() ) ){
        	erro = false;
            return "paginas/cadastro";
        } else {
        	FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario Invalido", "usuarioInvalido");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            
            erro = true;
            return "index";
        }
    }

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public LoginInterfDAO getDao() {
		return dao;
	}

	public void setDao(LoginInterfDAO dao) {
		this.dao = dao;
	}

	public boolean isErro() {
		return erro;
	}

	public void setErro(boolean erro) {
		this.erro = erro;
	}

	public boolean isUtilizaWebService() {
		return utilizaWebService;
	}

	public void setUtilizaWebService(boolean utilizaWebService) {
		this.utilizaWebService = utilizaWebService;
	}
}