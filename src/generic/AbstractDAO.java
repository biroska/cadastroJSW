package generic;

import java.util.logging.Logger;

import org.hibernate.Session;

import dao.BaseDAO;

public abstract class AbstractDAO <T> extends BaseDAO implements GenericDAO<T>{
        protected static final Logger log =  Logger.getLogger(AbstractDAO .class .getName());

        @SuppressWarnings("rawtypes" )
        private final Class typeClass ;

        @SuppressWarnings("rawtypes" )
        public AbstractDAO(Class argClass) { 
               typeClass = argClass; 
       }        

        public T save(T instance){
               log.info("inserindo dados na tabela " + typeClass .getName());
               Session session = getSessionFactory().openSession();
//               getSessionFactory().getCurrentSession().saveOrUpdate(instance);
               session.saveOrUpdate( instance );
               session.close();
               return instance;               
       }
}