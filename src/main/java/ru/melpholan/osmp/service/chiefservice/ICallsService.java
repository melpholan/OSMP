package ru.melpholan.osmp.service.chiefservice;

import ru.melpholan.osmp.domain.Calls;
import ru.melpholan.osmp.domain.Shifts;

import java.util.Date;
import java.util.List;

public interface ICallsService {

    List<Calls> callList();
    public List<Calls> findByDateInterval(Date start, Date finish);

}
