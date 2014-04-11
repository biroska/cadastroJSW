package facade;

import org.springframework.stereotype.Component;

import entidade.Cidade;
import entidade.Estado;

@Component("facade" )
public interface Facade {
        public boolean loginUsuario( String usuario, String senha );
        public Estado carregarEstadoPorSigla( String sigla );
		public void addCidade(Cidade cidade);
}