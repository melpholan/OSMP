package ru.melpholan.osmp.service.headdoctorservice;

import ru.melpholan.osmp.domain.DoctorsErrors;
import ru.melpholan.osmp.domain.ResultOfDoctorsCalls;

import java.util.Date;
import java.util.List;

public interface ICallsHeadService {

    public Long createCall(Date date, Long personal, Long errors, Long result);

    List<ResultOfDoctorsCalls> getResultOfCallList();
    List<DoctorsErrors> getDoctorsErrorsList();

}
