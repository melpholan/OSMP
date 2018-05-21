package ru.melpholan.osmp.service.chiefservice;

import ru.melpholan.osmp.buisness.premiumcounter.Result;
import ru.melpholan.osmp.domain.Personal;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IPremiumService {

    Map<Long, Result> calculatePremium(Date startPeriod, Date endPeriod, int money, double koefficient,
                                       int callsNorm);

    double calculateLoad(Date startPeriod, Date endPeriod);

    public List<Personal> getPersonals();
}
