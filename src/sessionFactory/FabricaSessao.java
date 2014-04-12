package sessionFactory;

import javax.annotation.PostConstruct;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

@Repository
public class FabricaSessao {

	public SessionFactory factory;
	
    @PostConstruct	
	public void criarSessionFactory() {

		Configuration configuration = new Configuration().configure();

		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());

		factory = configuration.buildSessionFactory(builder.build());

		System.out.println("FabricaSessao.criarSessionFactory(): " + factory );
		
	}
    
	public SessionFactory getSessionFactory() {

		Configuration configuration = new Configuration().configure();

		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());

		factory = configuration.buildSessionFactory(builder.build());

		System.out.println("FabricaSessao.criarSessionFactory(): " + factory );
		
		return factory;
		
	}
    
}