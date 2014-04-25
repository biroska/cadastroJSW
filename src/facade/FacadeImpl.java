package facade;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.CidadeDAO;
import dao.EstadoInterfDAO;
import dao.LoginDAO;
import dao.LogradouroDAO;
import entidade.Cidade;
import entidade.Estado;
import entidade.Logradouro;

@Component("facadeImpl")
public class FacadeImpl implements Facade {

	@Autowired
	CidadeDAO daoCidade;
	
	@Autowired
	EstadoInterfDAO daoEstado;
	
	@Autowired
	LogradouroDAO daoLogradouro;
	
	@Override
	public boolean loginUsuario(String usuario, String senha) {
		LoginDAO dao = new LoginDAO();
		return dao.loginUsuario(usuario, senha);
	}

	@Override
	public Estado carregarEstadoPorSigla(String sigla) {
		return daoEstado.carregarEstadoPorSigla(sigla);
	}

	
	@Override
	public void addEstado(Estado e){
//		daoEstado.addEstado(e);
		daoEstado.save( e );
	}

	@Override
	public void addCidade(Cidade cidade) {
		daoCidade.addCidade( cidade );
	}
	
	@Override
	public List<Logradouro> carregarTodosLogradouros(){
		return daoLogradouro.carregarTodosLogradouros();
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW, isolation=Isolation.SERIALIZABLE,	timeout=120)
	public void testarTransacao(){
		daoEstado.save( new Estado("TY", "TESTE_Y", "CAPITAL TESTE", "REGIAO") );
		daoLogradouro.carregarTodosLogradouros();
		daoEstado.save( new Estado("TZ", "TESTE_Z", "CAPITAL TESTE", "REGIAO") );
	}
	
	// Executado durante a inicialização do bean, definido no appContext
	@PostConstruct
	public void teste() throws Exception {
		System.out.println("======================================= FacadeImpl.teste() =======================================");
	}

}