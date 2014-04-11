package facade;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import dao.CidadeDAO;
import dao.EstadoDAO;
import dao.LoginDAO;
import entidade.Cidade;
import entidade.Estado;

@Component("facadeImpl")
public class FacadeImpl implements Facade {

	@Autowired
	CidadeDAO daoCidade;
	
	@Override
	public boolean loginUsuario(String usuario, String senha) {
		LoginDAO dao = new LoginDAO();
		return dao.loginUsuario(usuario, senha);
	}

	@Override
	public Estado carregarEstadoPorSigla(String sigla) {
		EstadoDAO daoEs = new EstadoDAO();
		return daoEs.carregarEstadoPorSigla(sigla);
	}

	@Override
	public void addCidade(Cidade cidade) {
//		CidadeDAO dao = new CidadeDAO();
		daoCidade.addCidade( cidade );
	}

	// Executado durante a inicialização do bean, definido no appContext
	@PostConstruct
	public void teste() throws Exception {
		System.out
				.println("======================================= FacadeImpl.teste() =======================================");
	}

}