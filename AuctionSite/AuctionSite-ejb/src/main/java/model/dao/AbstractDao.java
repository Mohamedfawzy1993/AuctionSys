package model.dao;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class AbstractDao<T> {

    private Class<T> entityType;

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void delete(T entity) {
        getEntityManager().remove(entity);
    }

    public void update(T entity) {
        getEntityManager().merge(entity);
    }

    public T find(int id) {
        return getEntityManager().find(entityType, id);
    }

    public T find(Class<T> entityType, int id) {
        return getEntityManager().find(entityType, id);
    }


}
