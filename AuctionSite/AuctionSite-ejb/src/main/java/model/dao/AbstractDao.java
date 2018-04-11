package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
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

    public List<T> findAll(Class<T> entityType)
    {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(entityType);
        Root<T> variableRoot = query.from(entityType);
        query.select(variableRoot);
        return getEntityManager().createQuery(query).getResultList();
    }


}
