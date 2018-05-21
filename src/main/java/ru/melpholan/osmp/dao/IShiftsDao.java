package ru.melpholan.osmp.dao;

import ru.melpholan.osmp.domain.Calls;
import ru.melpholan.osmp.domain.Shifts;

import java.util.Date;
import java.util.List;

public interface IShiftsDao extends IGenericDao<Shifts>{

    List<Shifts> findByDate(Date date);
    List<Shifts> findByDatesInterval(Date start, Date finish);


}
