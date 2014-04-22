package beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import webService.CepWebService;
import entidade.Cidade;
import entidade.Estado;
import facade.Facade;
 
@Component("cadastroMB")
@ManagedBean(name="cadastroMB")
@SessionScoped
public class CadastroBean {
     
    @Autowired
    private Usuario usuario;
    
    @Autowired
    private Facade facade;
    
    private String cepAlfa;
    
    private boolean erro = false;
    
    private String teste;
    
    public void buscaEndereco( ){
    	
    Boolean utilizaWebService = (Boolean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get( "utilizaWebService" ); // put("utilizaWebService", utilizaWebService );
    	    	
    	if ( utilizaWebService == true &&  cepAlfa != null && cepAlfa.length() == 9 ){
    		CepWebService cepWebService = new CepWebService( cepAlfa.replace("-", "") );
    		
    		if (cepWebService.getResultado() == 1) {
    			usuario.getEndereco().setLogradouro( cepWebService.getTipoLogradouro() );
    			usuario.getEndereco().setEndereco(   cepWebService.getLogradouro() );
    			usuario.getEndereco().setEstado(     cepWebService.getEstado() );
    			usuario.getEndereco().setCidade(     cepWebService.getCidade() );
    			usuario.getEndereco().setBairro(     cepWebService.getBairro() );
            } else {
     
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "O serviço está indisponível",
                                "O serviço está indisponível"));
            }
    	}
    	
//    	facade.addEstado( new Estado("TE", "TESTE", "CAPITAL TESTE", "REGIAO") );
//    	facade.addEstado( new Estado("T2", "TESTE_2", "CAPITAL TESTE_2", "REGIAO2") );
    	
    	System.out.println("CadastroBean.buscaEndereco(): " + facade.carregarEstadoPorSigla("SP").getNmEstado() );
    	
    }
    
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isErro() {
		return erro;
	}

	public void setErro(boolean erro) {
		this.erro = erro;
	}

	public String getCepAlfa() {
		return cepAlfa;
	}

	public void setCepAlfa(String cepAlfa) {
		this.cepAlfa = cepAlfa;
	}


	public String getTeste() {
		return teste;
	}


	public void setTeste(String teste) {
		this.teste = teste;
	}
}