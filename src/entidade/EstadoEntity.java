package entidade;

import org.springframework.stereotype.Component;

/**
 * Estado generated by hbm2java
 */
@Component
public class EstadoEntity extends Estado implements java.io.Serializable {

	public EstadoEntity() {	}

	public EstadoEntity(String sgEstado, String nmEstado, String nmCapital,
			String nmRegiao) {
		super.setSgEstado( sgEstado );
		super.setNmEstado( nmEstado );
		super.setNmCapital( nmCapital );
		super.setNmRegiao( nmRegiao );
	}
}