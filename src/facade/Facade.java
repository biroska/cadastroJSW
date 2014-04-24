package facade;

import java.util.List;

import org.springframework.stereotype.Component;

import entidade.Cidade;
import entidade.Estado;
import entidade.Logradouro;

@Component("facade" )
public interface Facade {
        public boolean loginUsuario( String usuario, String senha );
        public Estado carregarEstadoPorSigla( String sigla );
		public void addCidade(Cidade cidade);
		public void addEstado(Estado e);
		public List<Logradouro> carregarTodosLogradouros();
}