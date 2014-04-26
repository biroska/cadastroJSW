package entidade;

import org.springframework.stereotype.Component;

/**
 * Endereco generated by hbm2java
 */
@Component
public class EnderecoEntity extends Endereco implements java.io.Serializable {

	public EnderecoEntity() {}

	public EnderecoEntity(Logradouro logradouro, Cidade cidade, String dsEndereco,
			String dsNumero, String dsBairro, int nuCep) {
		super.setLogradouro( logradouro );
		super.setCidade( cidade );
		super.setDsEndereco( dsEndereco );
		super.setDsNumero( dsNumero );
		super.setDsBairro( dsBairro );
		super.setNuCep( nuCep );
	}
}