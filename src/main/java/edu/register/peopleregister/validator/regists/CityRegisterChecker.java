package edu.register.peopleregister.validator.regists;

import edu.register.peopleregister.domain.Person;
import edu.register.peopleregister.domain.register.CityRegisterResponse;
import edu.register.peopleregister.exception.CityRegisterException;
import edu.register.peopleregister.exception.TransportException;

public interface CityRegisterChecker {

    CityRegisterResponse checkPerson(Person person)
            throws CityRegisterException, TransportException;
}
