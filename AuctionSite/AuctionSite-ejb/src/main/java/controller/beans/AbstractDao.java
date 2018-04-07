package controller.beans;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class AbstractDao<T> {

    protected Class<T> entityType;

    protected abstract EntityManager getEntityManager();
    public abstract void create(T entity);
    public abstract void delete(T entity);
    public abstract void update(T entity);
    public abstract List<T> select(String query);
    public T find(int id)
    {
        return getEntityManager().find(entityType , id);
    }


}
