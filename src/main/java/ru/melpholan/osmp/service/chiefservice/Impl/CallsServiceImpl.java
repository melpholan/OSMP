package ru.melpholan.osmp.service.chiefservice.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.melpholan.osmp.dao.ICallsDao;
import ru.melpholan.osmp.domain.Calls;
import ru.melpholan.osmp.service.chiefservice.ICallsService;

import java.util.Date;
import java.util.List;

@Service
public class CallsServiceImpl implements ICallsService{

    @Autowired
    ICallsDao callsDao;


    @Transactional
    @Override
    public List<Calls> callList() {

        return callsDao.findAll();

    }

    @Transactional
    @Override
    public List<Calls> findByDateInterval(Date start, Date finish){

        return callsDao.findByDatesInterval(start, finish);
    }
}
