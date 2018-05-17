package ru.melpholan.osmp.dao.Impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public abstract class AbstractHibernateDao <T extends Serializable>{

    protected void intMethod(){
        System.out.println("Init "+ this.getClass().getName());
    }

    private Class< T > clazz;

    @Autowired
    protected SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected final Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }


    public final void setClazz( Class< T > clazzToSet ){
        this.clazz = clazzToSet;
    }

    public T findOne( long id ){
        return (T) getCurrentSession().get( clazz, id );
    }


    public List< T > findAll(){
        return getCurrentSession().createQuery( "from " + clazz.getName() ).list();
    }

    public void create( T entity ){
        getCurrentSession().persist( entity );
    }

    public void update( T entity ){
        getCurrentSession().merge( entity );
    }

    public void delete( T entity ){
        getCurrentSession().delete( entity );
    }
    public void deleteById( long entityId ) {
        T entity = findOne( entityId );
        delete( entity );
    }

}
