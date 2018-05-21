package ru.melpholan.osmp.dao.Impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.melpholan.osmp.dao.ICallsDao;
import ru.melpholan.osmp.domain.Calls;

import java.util.Date;
import java.util.List;


@Repository
public class CallsDaoImpl extends GenericHibernateDao<Calls> implements ICallsDao {

    public CallsDaoImpl() {setClazz(Calls.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Calls> findByDate(Date date) {
        org.hibernate.Query query = getCurrentSession().createQuery(
                "from Calls cls where cls.dateOfCall= :date");
        query.setParameter("date", date);
        return query.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Calls> findByDatesInterval(Date start, Date finish) {
        Query query = getCurrentSession().createQuery(
                "from Calls cls where cls.dateOfCall between :start and :finish");
        query.setParameter("start", start);
        query.setParameter("finish", finish);
        return query.list();
    }
}
