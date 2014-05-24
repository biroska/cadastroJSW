package beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uteis.ValidacaoGenerica;
import webService.CepWebService;
import entidade.Logradouro;
import entidade.UsuarioEntity;
import facade.Facade;
 
@Component("cadastroMB")
@ManagedBean(name="cadastroMB")
@SessionScoped
public class CadastroBean {
     
    @Autowired
    private Facade facade;
    
    @Autowired
    private UsuarioEntity usuario2;
    
    private String cepAlfa;
    
    private List<Logradouro> logradouros;
    
    private String logradouroSelecionado;
    
    private boolean erro = false;
    
    private String teste;
    
    public void onLoadSetaCampos( ComponentSystemEvent event ){
    	
    	logradouros = logradouros != null ? logradouros : facade.carregarTodosLogradouros();
    	System.out.println("CadastroBean.onLoadSetaCampos()");
    	logradouroSelecionado = logradouros.get(2).getNmLogradouro();
    }
    
    public void alterouComboLogradouro()
    {
      System.out.println("CadastroBean.getLoginBranchId(): " + logradouroSelecionado );
    }
    
    public void buscaEndereco( ){
    	
    	Boolean utilizaWebService = (Boolean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get( "utilizaWebService" ); // put("utilizaWebService", utilizaWebService );
    	    	
    	if ( utilizaWebService == true &&  cepAlfa != null && cepAlfa.length() == 9 ){
    		CepWebService cepWebService = new CepWebService( cepAlfa.replace("-", "") );
    		
    		if (cepWebService.getResultado() == 1) {

    			usuario2.getEndereco().setDsEndereco( cepWebService.getLogradouro() );
    			usuario2.getEndereco().setDsBairro( cepWebService.getBairro() );
    			usuario2.getEndereco().getLogradouro().setNmLogradouro( cepWebService.getTipoLogradouro() );
    			usuario2.getEndereco().getCidade().setNmCidade( cepWebService.getCidade() );
    			usuario2.getEndereco().getCidade().getEstado().setSgEstado( cepWebService.getEstado() );

    			/* manda o logradouro para o combo na tela */
    			logradouroSelecionado = usuario2.getEndereco().getLogradouro().getNmLogradouro();
    			
            } else {
     
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "O serviço está indisponível",
                                "O serviço está indisponível"));
            }
    		
    		System.out.println("CadastroBean.buscaEndereco(): " + logradouroSelecionado);
    		
    	}

//    	facade.testarTransacao();
    	
//    	facade.addEstado( new Estado("TE", "TESTE", "CAPITAL TESTE", "REGIAO") );
//    	
//    	System.out.println("CadastroBean.buscaEndereco(): " + facade.carregarEstadoPorSigla("SP").getNmEstado() );
    	
    }
    
    private boolean validar(){
    	boolean valido = true;
    	
    	ValidacaoGenerica.validarObrigatorio( usuario2.getNmUsuario(), "Nome Completo Obrigatório" );
    	
    	ValidacaoGenerica.validarObrigatorio( usuario2.getDsLogin(), "Login Obrigatório" );
    	
    	ValidacaoGenerica.validarObrigatorio( usuario2.getDsSenha(), "Senha Obrigatória" );
    	
//    	teste( usuario2.getNmUsuario() );
    	
    	return valido; 
    }
    
    public void gravar()
    {
    	System.out.println("CadastroBean.gravar()");
    	
    	validar();
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

	public String getLogradouroSelecionado() {
		return logradouroSelecionado;
	}

	public void setLogradouroSelecionado(String logradouroSelecionado) {
		this.logradouroSelecionado = logradouroSelecionado;
	}

	public UsuarioEntity getUsuario2() {
		return usuario2;
	}

	public void setUsuario2(UsuarioEntity usuario2) {
		this.usuario2 = usuario2;
	}
}