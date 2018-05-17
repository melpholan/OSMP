package ru.melpholan.osmp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.melpholan.osmp.domain.Personal;
import ru.melpholan.osmp.service.chiefservice.IPersonalService;

import java.util.Map;

@Controller
public class PersonalController {

    @Autowired
    IPersonalService personalService;

    @RequestMapping("/index")
    public String listContacts(Map<String, Object> map) {

        System.out.println(personalService.listPersonal());

        map.put("personal", new Personal());
        map.put("personalList", personalService.listPersonal());

        return "personal";
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("personal") Personal personal,
                             BindingResult result) {

        personalService.createPersonal(personal);

        return "redirect:/index";
    }

    @RequestMapping("/delete/{personalId}")
    public String deleteContact(@PathVariable("personalId") Long contactId) {

        personalService.removePersonal(contactId);

        return "redirect:/index";
    }
}
