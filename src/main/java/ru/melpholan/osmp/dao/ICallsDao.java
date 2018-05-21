package ru.melpholan.osmp.dao;


import ru.melpholan.osmp.domain.Calls;

import java.util.Date;
import java.util.List;


public interface ICallsDao extends IGenericDao<Calls>{

    List<Calls> findByDate(Date date);
    List<Calls> findByDatesInterval(Date start, Date finish);

}
