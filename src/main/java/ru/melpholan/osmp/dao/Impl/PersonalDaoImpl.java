package ru.melpholan.osmp.dao.Impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import ru.melpholan.osmp.dao.IPersonalDao;
import ru.melpholan.osmp.domain.Personal;

@Repository
public class PersonalDaoImpl extends GenericHibernateDao<Personal> implements IPersonalDao {

    public PersonalDaoImpl(){
        setClazz(Personal.class);
    }


    @Override
    public Personal findPersonByName(String name) {

        Query query = getCurrentSession().createQuery("from Personal p where p.name = :name");
        query.setParameter("name", name);
        return (Personal) query.uniqueResult();
    }

    @Override
    public Personal findPersonalByFullName(String name, String surname) {
        Query query = getCurrentSession().createQuery("from Personal p where p.name = :name and p.surname = :surname");
        query.setParameter("name", name);
        query.setParameter("surname", surname);
        return (Personal) query.uniqueResult();
    }


}
