package ru.melpholan.osmp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.melpholan.osmp.domain.Personal;
import ru.melpholan.osmp.service.chiefservice.IPersonalService;

import java.util.Map;

@Controller
public class PersonalListController {

    @Autowired
    IPersonalService personalService;

    @RequestMapping("/persList")
    public String listContacts(ModelMap map) {

        System.out.println(personalService.listPersonal());

        map.addAttribute("personalList", personalService.listPersonal());

        return "personalList";
    }

}
