package generic;

import daoInterf.BaseInterfDAO;

public interface GenericDAO<T> extends BaseInterfDAO {
    public T save(T instance);
}
