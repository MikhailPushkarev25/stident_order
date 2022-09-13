package edu.register.peopleregister.dao;

import edu.register.peopleregister.domain.CountryArea;
import edu.register.peopleregister.domain.PassportOffice;
import edu.register.peopleregister.domain.RegisterOffice;
import edu.register.peopleregister.domain.Street;
import edu.register.peopleregister.exception.DaoException;

import java.util.List;

public interface DictionaryDao {

    List<Street> findStreets(String pattern) throws DaoException;

    List<PassportOffice> findPassportOffices(String areaId) throws DaoException;

    List<RegisterOffice> findRegisterOffices(String areaId) throws DaoException;

    List<CountryArea> findAreas(String areaId) throws DaoException;


}
