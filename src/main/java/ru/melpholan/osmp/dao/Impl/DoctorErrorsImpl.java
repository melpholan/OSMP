package ru.melpholan.osmp.dao.Impl;

import org.springframework.stereotype.Repository;
import ru.melpholan.osmp.dao.IDoctorsErrorsDao;
import ru.melpholan.osmp.domain.DoctorsErrors;

@Repository
public class DoctorErrorsImpl extends GenericHibernateDao<DoctorsErrors> implements IDoctorsErrorsDao {

    public DoctorErrorsImpl() {

        setClazz(DoctorsErrors.class);
    }


}
