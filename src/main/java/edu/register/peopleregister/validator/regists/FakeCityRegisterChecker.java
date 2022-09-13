package edu.register.peopleregister.validator.regists;

import edu.register.peopleregister.domain.Adult;
import edu.register.peopleregister.domain.Child;
import edu.register.peopleregister.domain.Person;
import edu.register.peopleregister.domain.register.CityRegisterResponse;
import edu.register.peopleregister.exception.CityRegisterException;
import edu.register.peopleregister.exception.TransportException;

public class FakeCityRegisterChecker implements CityRegisterChecker {

    private static final String GOOD_1 = "1000";
    private static final String GOOD_2 = "2000";
    private static final String BAD_1 = "1001";
    private static final String BAD_2 = "2001";
    private static final String ERROR_1 = "1002";
    private static final String ERROR_2 = "2002";
    private static final String ERROR_T_1 = "1003";
    private static final String ERROR_T_2 = "2003";

    @Override
    public CityRegisterResponse checkPerson(Person person) throws CityRegisterException, TransportException {
        CityRegisterResponse res = new CityRegisterResponse();
        if (person instanceof Adult t) {
            String ps = t.getPassportSeria();
            if (ps.equals(GOOD_1) || ps.equals(GOOD_2)) {
                res.setExisting(true);
                res.setTemporal(false);
            }
            if (ps.equals(BAD_1) || ps.equals(BAD_2)) {
                res.setExisting(false);
            }
            if (ps.equals(ERROR_1) || ps.equals(ERROR_2)) {
                throw new CityRegisterException("1", "GRN ERROR " + ps);
            }
            if (ps.equals(ERROR_T_1) || ps.equals(ERROR_T_2)) {
                throw new TransportException("Transport ERROR " + ps);
            }
        }

        if (person instanceof Child) {
            res.setExisting(true);
            res.setTemporal(true);
        }
        System.out.println(res);
        return res;
    }
}
