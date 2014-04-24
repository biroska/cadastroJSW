package generic;

import dao.BaseInterfDAO;

public interface GenericDAO<T> extends BaseInterfDAO {
    public T save(T instance);
}
