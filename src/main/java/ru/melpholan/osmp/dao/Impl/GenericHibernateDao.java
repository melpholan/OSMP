package ru.melpholan.osmp.dao.Impl;


import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import ru.melpholan.osmp.dao.IGenericDao;

import java.io.Serializable;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GenericHibernateDao <T extends Serializable>
        extends AbstractHibernateDao<T> implements IGenericDao<T> {
}
