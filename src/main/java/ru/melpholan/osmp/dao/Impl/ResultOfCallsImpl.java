package ru.melpholan.osmp.dao.Impl;

import org.springframework.stereotype.Repository;
import ru.melpholan.osmp.dao.IResultOfCallsDao;
import ru.melpholan.osmp.domain.ResultOfDoctorsCalls;


@Repository
public class ResultOfCallsImpl extends GenericHibernateDao<ResultOfDoctorsCalls> implements IResultOfCallsDao{


    public ResultOfCallsImpl() {

        setClazz(ResultOfDoctorsCalls.class);
    }
}
