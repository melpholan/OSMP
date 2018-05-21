package ru.melpholan.osmp.buisness.premiumcounter;

import ru.melpholan.osmp.domain.Calls;
import ru.melpholan.osmp.domain.Shifts;

import java.util.*;

public class PremCounter {

    public static Map<Long, Result> getDoctorsResultList(List<Calls> calls, List<Shifts> shifts,
                                        int money, double mulKoefficient, int callsNorm){
        Map<Long, Result> resultMap = new HashMap<>();

        countResultList(resultMap, calls, shifts);
        ballsMultiplier(resultMap, callsNorm, mulKoefficient);
        double ballsCoaster = ballsCoaster(resultMap, money);
        getPremiumSummList(resultMap,ballsCoaster);

        return resultMap;
    }

    public static double getLoadForPeriod(List<Calls> callList, final List<Shifts> shiftsList){

        Map<Long, Result> resultMap = new HashMap<>();

        countResultList(resultMap, callList, shiftsList);

        double load = 0;
        int workHours = 0;
        int calls = 0;


        Collection<Result> collection = resultMap.values();
        for (Result result: collection
                ) {
            workHours += result.getWorkHours();
            calls += result.getCalls();
        }
        load = calls / (workHours/24D);
        return load;

    }

    public static double getLoadForPeriod(Map<Long,Result> resultMap){

        double load = 0;
        int workHours = 0;
        int calls = 0;


        Collection<Result> collection = resultMap.values();
        for (Result result: collection
                ) {
            workHours += result.getWorkHours();
            calls += result.getCalls();
        }
        load = calls / (workHours/24D);
        return load;

    }

    public static void getPremiumSummList(Map<Long, Result> resultMap, final double ballsCoast){

       // Map<Long, Result> moneyMap = new HashMap<>();

        for (Long ID: resultMap.keySet()
                ) {

            Result result = resultMap.get(ID);
            double prem = result.getBall();
            prem = prem*ballsCoast;
            result.setPremium(prem);

            resultMap.put(ID, result);
        }

        //return moneyMap;
    }


    public static double ballsCoaster(Map<Long, Result> resultMap, final int money){

        double ballsSum = 0;
        Collection<Result> values = resultMap.values();
        for (Result res:values
                ) {
            ballsSum = ballsSum + res.getBall();
        }

        return money / ballsSum;

    }

    public static void ballsMultiplier(Map<Long, Result> resultMap,
                                                     final int callsNorm, final double mulKofficient){

        for (Long key: resultMap.keySet()
                ) {

            Result res = resultMap.get(key);

            //int load = (int)(res.getCalls()/(res.getWorkHours()/24D));

            double load = res.getLoad();

            double ball = res.getBall();

            if(load < callsNorm){
                res.setBall( (ball -mulKofficient* ball) );
            }

            if(load > ( callsNorm * (1 + mulKofficient) ) ){

                res.setBall( (ball + mulKofficient* ball) );

            }

            resultMap.put(key, res);

        }

       // return resultMap;

    }


    //count List of doctors work results
    public static void countResultList( Map<Long, Result> resultMap, List<Calls> callList, List<Shifts> shiftsList) {


        resultCounter(resultMap,callList);
        Map<Long, Integer> hoursMap = hoursCounter(shiftsList);

        for (Long ID : resultMap.keySet()
                ) {

            Integer hours = 0;
            Result result = resultMap.get(ID);
            if ((hours = hoursMap.get(ID)) != null)

                result.setWorkHours(hours);
                resultMap.put(ID, result);
        }

        }






    //count summ hours for doctors
    public static Map<Long, Integer> hoursCounter(List<Shifts> shiftsList){

        Map<Long, Integer> shiftsTimeMap = new HashMap<>();


        for (Shifts shift: shiftsList
                ) {

            Long ID = shift.getPersonal().getIdPersonal();//getShiftsDoctorsID();
            Integer hours = shift.getShiftTypes().getHoursQuantity();//getShiftsHoursQuantity();


            if(shiftsTimeMap.containsKey(ID)){

                Integer result = shiftsTimeMap.get(ID);
                shiftsTimeMap.put(ID, (result + hours) );

            }else {

                shiftsTimeMap.put(ID, hours);
            }

        }


        return shiftsTimeMap;
    }

    //count Results for doctors
    public static void resultCounter( Map<Long, Result> resultMap, List<Calls> callList){

        //Map<Long, Result> resultMap = new HashMap<>();

        for (Calls call: callList
                ) {

            Long ID = call.getPersonal().getIdPersonal();//getDoctorID();

            if(resultMap.containsKey(ID)){

                Result res = resultMap.get(ID);
                res = callSummator(call, res);
                resultMap.put(ID, res);

            }else {

                Result res = new Result();
                res = callSummator(call, res);
                resultMap.put(ID, res);
            }

        }

     //   return resultMap;

    }


    //for summ balls calls and errors
    public static Result callSummator(Calls call, Result result){

        //Result result = new Result();

        int err = call.getDoctorsErrors().getErrorScale();

        result.setBall(-err);//getError());
        result.setCalls();
        result.setErrors(err);//getError());
        return result;
    }
}
