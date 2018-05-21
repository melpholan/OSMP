package ru.melpholan.osmp.service.headdoctorservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.melpholan.osmp.dao.ICallsDao;
import ru.melpholan.osmp.dao.IDoctorsErrorsDao;
import ru.melpholan.osmp.dao.IPersonalDao;
import ru.melpholan.osmp.dao.IResultOfCallsDao;
import ru.melpholan.osmp.domain.Calls;
import ru.melpholan.osmp.domain.DoctorsErrors;
import ru.melpholan.osmp.domain.Personal;
import ru.melpholan.osmp.domain.ResultOfDoctorsCalls;
import ru.melpholan.osmp.service.headdoctorservice.ICallsHeadService;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Service
public class CallsHeadServiceImpl implements ICallsHeadService{

    @Autowired
    ICallsDao callsDao;

    @Autowired
    IPersonalDao personalDao;

    @Autowired
    IResultOfCallsDao resultOfCallsDao;


    @Autowired
    IDoctorsErrorsDao doctorsErrorsDao;


    @Transactional
    @Override
    public List<ResultOfDoctorsCalls> getResultOfCallList() {
       return resultOfCallsDao.findAll();
    }

    @Transactional
    @Override
    public List<DoctorsErrors> getDoctorsErrorsList() {
        return doctorsErrorsDao.findAll();
    }

    @Transactional
    @Override
    public Long createCall(Date date, Long personal, Long errors, Long result) {

        Calls call = new Calls();
        Personal pers = personalDao.findOne(personal);
        ResultOfDoctorsCalls res = resultOfCallsDao.findOne(result);
        DoctorsErrors err = doctorsErrorsDao.findOne(errors);

        call.setDateOfCall(date);
        call.setPersonal(pers);
        call.setDoctorsErrors(err);
        call.setResultOfDoctorsCalls(res);

        Long id = (Long) callsDao.create(call);
        return id;
    }
}
