package ru.melpholan.osmp.service.chiefservice.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.melpholan.osmp.dao.IPersonalDao;
import ru.melpholan.osmp.domain.Passport;
import ru.melpholan.osmp.domain.Personal;
import ru.melpholan.osmp.service.chiefservice.IPersonalService;

import java.util.List;

@Service
public class PersonalServiceImpl implements IPersonalService {


    @Autowired
    IPersonalDao personalDao;


    @Override
    public void createPersonal(Personal personal) {

    }

    @Transactional
    @Override
    public List<Personal> listPersonal() {
        return personalDao.findAll();
    }

    @Override
    public void removePersonal(Long ID) {
        personalDao.deleteById(ID);
    }

    @Override
    public Personal findPersonal(Personal personal) {
        return null;
    }

    @Override
    public Personal getPersonalByID(Long ID) {
        return null;
    }

    @Override
    public void updatePersonal(Personal personal, String name, String surname, String patronymic) {

    }

    @Override
    public void addPassport(Personal personal, Passport passport) {

    }

    @Override
    public void createAddress() {

    }

    @Override
    public void createContacts() {

    }
}
