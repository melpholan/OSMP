package ru.melpholan.osmp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.melpholan.osmp.domain.Calls;
import ru.melpholan.osmp.domain.DoctorsErrors;
import ru.melpholan.osmp.domain.Personal;
import ru.melpholan.osmp.domain.ResultOfDoctorsCalls;
import ru.melpholan.osmp.service.chiefservice.IPersonalService;
import ru.melpholan.osmp.service.headdoctorservice.ICallsHeadService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/savecalls")
public class CallsSaverController {


    @Autowired
    ICallsHeadService headService;

    @Autowired
    IPersonalService personalService;



    @RequestMapping("/create")
    public String createcall(ModelMap map){

        List<Personal> personals = personalService.listPersonal();
        map.addAttribute("names", personals);

        List<DoctorsErrors> doctorsErrorsList = headService.getDoctorsErrorsList();

        List<ResultOfDoctorsCalls> resultOfCallList = headService.getResultOfCallList();

        map.addAttribute("errors",doctorsErrorsList);
        map.addAttribute("callstypes",resultOfCallList);


        return "createCall";
    }

    @RequestMapping(value = "/callsCreate", method = RequestMethod.GET)
    public String save(@RequestParam("start") String start,
                                          @RequestParam("name") String name,
                       @RequestParam("error") String error,
                       @RequestParam("callstype") String callstypes,
                       ModelMap map)
    {

        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyy-mm-dd");

        Date st = null;
        Long err = null;
        Long nam = null;
        Long ct = null;


        try {
            st= format.parse(start);
             err = Long.valueOf(error);
             nam = Long.valueOf(name);
             ct = Long.valueOf(callstypes);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        headService.createCall(st,nam,err,ct);



        return "redirect:create";
    }



}
