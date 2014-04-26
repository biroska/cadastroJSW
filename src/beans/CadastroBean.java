package beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import webService.CepWebService;
import entidade.Endereco;
import entidade.Logradouro;
import entidade.UsuarioEntity;
import facade.Facade;
 
@Component("cadastroMB")
@ManagedBean(name="cadastroMB")
@SessionScoped
public class CadastroBean {
     
    @Autowired
    private Usuario usuario;
    
    @Autowired
    private Facade facade;
    
    @Autowired
    private UsuarioEntity usuario2;
    
    private String cepAlfa;
    
    private List<Logradouro> logradouros;
    
    private Logradouro logradouro = new Logradouro();
    
    private boolean erro = false;
    
    private String teste;
    
    public void onLoadSetaCampos( ComponentSystemEvent event ){
    	
    	logradouros = logradouros != null ? logradouros : facade.carregarTodosLogradouros();
    }
    
    public void buscaEndereco( ){
    	
    	Boolean utilizaWebService = (Boolean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get( "utilizaWebService" ); // put("utilizaWebService", utilizaWebService );
    	    	
    	if ( utilizaWebService == true &&  cepAlfa != null && cepAlfa.length() == 9 ){
    		CepWebService cepWebService = new CepWebService( cepAlfa.replace("-", "") );
    		
    		if (cepWebService.getResultado() == 1) {

    			usuario2.getEndereco().setDsEndereco( cepWebService.getLogradouro() );
    			usuario2.getEndereco().setDsBairro( cepWebService.getBairro() );
    			/* Falta mandar o logradouro para a tela */
    			usuario2.getEndereco().getLogradouro().setNmLogradouro( cepWebService.getTipoLogradouro() );
    			usuario2.getEndereco().getCidade().setNmCidade( cepWebService.getCidade() );
    			usuario2.getEndereco().getCidade().getEstado().setSgEstado( cepWebService.getEstado() );
    			
            } else {
     
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "O serviço está indisponível",
                                "O serviço está indisponível"));
            }
    	}

//    	facade.testarTransacao();
    	
//    	facade.addEstado( new Estado("TE", "TESTE", "CAPITAL TESTE", "REGIAO") );
//    	
//    	System.out.println("CadastroBean.buscaEndereco(): " + facade.carregarEstadoPorSigla("SP").getNmEstado() );
    	
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

	public List<Logradouro> getLogradouros() {
		return logradouros;
	}

	public void setLogradouros(List<Logradouro> logradouros) {
		this.logradouros = logradouros;
	}

	public Logradouro getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}

	public UsuarioEntity getUsuario2() {
		return usuario2;
	}

	public void setUsuario2(UsuarioEntity usuario2) {
		this.usuario2 = usuario2;
	}
}