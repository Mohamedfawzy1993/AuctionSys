package model.dao;


import java.util.List;

public interface DaoInterface<T> {

    public List<T> select(T user);

    public List<T> select(String query);

    public List<T> selectByNamedQuery(String namedQuery , String value);

    public void insert(T user);

    public void update(T user);

    public void delete(T user);
}
