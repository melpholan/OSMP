package ru.melpholan.osmp.service.chiefservice.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import ru.melpholan.osmp.buisness.premiumcounter.PremCounter;
import ru.melpholan.osmp.buisness.premiumcounter.Result;
import ru.melpholan.osmp.dao.ICallsDao;
import ru.melpholan.osmp.dao.IPersonalDao;
import ru.melpholan.osmp.dao.IShiftsDao;
import ru.melpholan.osmp.domain.Calls;
import ru.melpholan.osmp.domain.Personal;
import ru.melpholan.osmp.domain.Shifts;
import ru.melpholan.osmp.service.chiefservice.IPremiumService;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@EnableTransactionManagement
public class PremiumServiceImpl implements IPremiumService{

    @Autowired
    ICallsDao callsDao;

    @Autowired
    IShiftsDao shiftsDao;

    @Autowired
    IPersonalDao personalDao;


    @Override
    @Transactional
    public Map<Long, Result> calculatePremium(Date startPeriod, Date endPeriod,
                                              int money, double koefficient, int callsNorm) {

        List<Calls> calls = callsDao.findByDatesInterval(startPeriod, endPeriod);
        List<Shifts> shifts = shiftsDao.findByDatesInterval(startPeriod, endPeriod);

        Map<Long, Result> doctorsResultList = PremCounter.getDoctorsResultList(calls, shifts, money, koefficient, callsNorm);

        return doctorsResultList;

    }

    @Override
    @Transactional
    public double calculateLoad(Date startPeriod, Date endPeriod) {

        List<Calls> calls = callsDao.findByDatesInterval(startPeriod, endPeriod);
        List<Shifts> shifts = shiftsDao.findByDatesInterval(startPeriod, endPeriod);

        return PremCounter.getLoadForPeriod(calls, shifts);
    }

    @Transactional
    public List<Personal> getPersonals(){
        return personalDao.findAll();
    }
}
