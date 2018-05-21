package ru.melpholan.osmp.dao.Impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.melpholan.osmp.dao.IShiftsDao;
import ru.melpholan.osmp.domain.Calls;
import ru.melpholan.osmp.domain.Shifts;

import java.util.Date;
import java.util.List;

@Repository
public class ShiftsDaoImpl extends GenericHibernateDao<Shifts>implements IShiftsDao{

    public ShiftsDaoImpl() {

        setClazz(Shifts.class);
    }

    @Override
    public List<Shifts> findByDate(Date date) {
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Shifts> findByDatesInterval(Date start, Date finish) {
        Query query = getCurrentSession().createQuery(
                "from Shifts s where s.workDate between :start and :finish");
        query.setParameter("start", start);
        query.setParameter("finish", finish);
        return query.list();
    }
}
