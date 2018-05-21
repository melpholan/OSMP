package ru.melpholan.osmp.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.melpholan.osmp.buisness.premiumcounter.PremCounter;
import ru.melpholan.osmp.buisness.premiumcounter.Result;
import ru.melpholan.osmp.dao.ICallsDao;
import ru.melpholan.osmp.dao.IShiftsDao;
import ru.melpholan.osmp.domain.Calls;
import ru.melpholan.osmp.domain.Personal;
import ru.melpholan.osmp.domain.Shifts;
import ru.melpholan.osmp.service.chiefservice.IPremiumService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/prem")
public class PremiumCountController {

    @Autowired
    IPremiumService premiumService;


    @RequestMapping("/premium")
    public String getPremium(){

        return "getPremiumList";
    }

//    @RequestMapping(value = "/calculate", method = RequestMethod.GET)
//    public String calculate(@RequestParam("start") String start,
//                                   @RequestParam("finish") String finish,
//                                   @RequestParam("money") String money,
//                                   @RequestParam("coefficient") String coefficient,
//                                   @RequestParam("callsNorm") String callsNorm, ModelMap map){
//
//        SimpleDateFormat format = new SimpleDateFormat();
//        format.applyPattern("yyyy-mm-dd");
//
//
//        Date st = null;
//        Date fin = null;
//        int m = Integer.valueOf(money);
//        double c = Double.valueOf(coefficient);
//        int n = Integer.valueOf(callsNorm);
//
//        try {
//            st= format.parse(start);
//            fin= format.parse(finish);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        List<Shifts> shifts = shiftsDao.findByDatesInterval(st, fin);
//        List<Calls> calls = callsDao.findByDatesInterval(st, fin);
//
//        Map<Long, Result> RESULT = new HashMap<>();
//
//        //map.addAttribute("shifts", shifts);
//        //map.addAttribute("calls", calls);
//        Map<Long, Integer> hoursCounter = PremCounter.hoursCounter(shifts);
//        map.addAttribute("hoursCounter", hoursCounter);
//
//        PremCounter.resultCounter(RESULT,calls);
//
//
//        PremCounter.countResultList(RESULT,calls,shifts);
//
//
//        map.addAttribute("rmap",RESULT);
//
//
//        return "calculate";
//    }

    @RequestMapping(value = "/calculatePremium", method = RequestMethod.GET)
    public String calculatePremium(@RequestParam("start") String start,
                                   @RequestParam("finish") String finish,
                                   @RequestParam("money") String money,
                                   @RequestParam("coefficient") String coefficient,
                                   @RequestParam("callsNorm") String callsNorm, ModelMap map){

        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyy-mm-dd");


        Date st = null;
        Date fin = null;
        int m = Integer.valueOf(money);
        double c = Double.valueOf(coefficient);
        int n = Integer.valueOf(callsNorm);

        try {
            st= format.parse(start);
            fin= format.parse(finish);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Map<Long, Result> premiumMap = premiumService.calculatePremium(st, fin, m, c, n);
        map.addAttribute("premiumMap", premiumMap);

        List<Personal> personals = premiumService.getPersonals();

        Map<Long,Personal> personalMap = new HashMap<>();

        for (Personal p: personals
             ) {

            personalMap.put(p.getIdPersonal(),p);

        }

        map.addAttribute("personal", personalMap);

        double load = premiumService.calculateLoad(st, fin);

        map.addAttribute("load",load);


        return "premiumList";
    }

}
