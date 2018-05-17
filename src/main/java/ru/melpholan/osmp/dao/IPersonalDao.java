package ru.melpholan.osmp.dao;

import ru.melpholan.osmp.domain.Personal;

public interface IPersonalDao extends IGenericDao<Personal> {

    Personal findPersonByName(String name);
    Personal findPersonalByFullName(String name, String surname);
}
