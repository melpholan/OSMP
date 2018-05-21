package ru.melpholan.osmp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.melpholan.osmp.domain.Calls;
import ru.melpholan.osmp.domain.Personal;
import ru.melpholan.osmp.service.chiefservice.ICallsService;
import ru.melpholan.osmp.service.chiefservice.IPersonalService;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/calls")
public class CallsListController {


    @Autowired
    ICallsService callsService;

    @RequestMapping("/cls")
    public String getCallsBydate(){

        return "getСallsListByDate";
    }

    @RequestMapping("/callsList")
    public String listCalls(ModelMap map) {

        map.addAttribute("calls",callsService.callList());

        return "callsList";
    }

    @RequestMapping(value = "/callsByDateInterval", method = RequestMethod.GET)
    public String listCallsByDateInterval(@RequestParam("start") String start,
                                          @RequestParam("finish") String finish, ModelMap map)
     {

         SimpleDateFormat format = new SimpleDateFormat();
         format.applyPattern("yyyy-mm-dd");

        Date st = null;
        Date fin = null;

        try {
            st= format.parse(start);
            fin= format.parse(finish);
        } catch (ParseException e) {
            e.printStackTrace();
        }

         List<Calls> byDateInterval = callsService.findByDateInterval(st, fin);
        map.addAttribute("calls",byDateInterval);

        return "callsList";
    }

}
