package beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import registration.bo.impl.RegistrationBoImpl;
import dao.LoginDAO;
import facade.Facade;
 
@Component("loginMB")
@ManagedBean(name="loginMB")
@SessionScoped
public class LoginBean {
     
    @Autowired
    RegistrationBoImpl registrationBo;
    
    @Autowired
    Usuario user;
    
    @Autowired
    LoginDAO dao;
    
    @Autowired
    Facade facade;
     
    private String usuario;
    private String senha;
    private boolean erro = false;
    private boolean utilizaWebService = false;
     
    public String login() {
        
        System.out.println("RegistrationUserBean:: Registering user " + usuario + " " + senha + " - utilizaWebService: " + utilizaWebService );
        
// Seta na sessao a opçao de usar o webservice ou não        
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("utilizaWebService", utilizaWebService );
        
        if ( facade.loginUsuario( usuario, senha ) ){
        	erro = false;
            return "paginas/cadastro";
        } else {
        	FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario Invalido", "usuarioInvalido");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            
            erro = true;
            return "index";
        }
    }

	public RegistrationBoImpl getRegistrationBo() {
		return registrationBo;
	}

	public void setRegistrationBo(RegistrationBoImpl registrationBo) {
		this.registrationBo = registrationBo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public LoginDAO getDao() {
		return dao;
	}

	public void setDao(LoginDAO dao) {
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