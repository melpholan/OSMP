package ru.melpholan.osmp.dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao <T extends Serializable> {

    T findOne(final long id);

    List<T> findAll();

    Serializable create(final T entity);

    void update(final T entity);

    void delete(final T entity);

    void deleteById(final long entityId);

}
