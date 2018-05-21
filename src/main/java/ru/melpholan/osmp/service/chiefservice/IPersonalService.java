package ru.melpholan.osmp.service.chiefservice;

import ru.melpholan.osmp.domain.Passport;
import ru.melpholan.osmp.domain.Personal;

import java.util.List;

public interface IPersonalService {


    void createPersonal(Personal personal);

    List<Personal> listPersonal();

    Personal findPersonal(Personal personal);

    Personal getPersonalByID(Long ID);

    void removePersonal(Long ID);

    void updatePersonal(Personal personal, String name, String surname, String patronymic);

    void addPassport(Personal personal, Passport passport);

    void createAddress();

    void createContacts();


}
