package edu.register.peopleregister.validator;

import edu.register.peopleregister.domain.Person;
import edu.register.peopleregister.domain.register.AnswerCityRegister;
import edu.register.peopleregister.domain.Child;
import edu.register.peopleregister.domain.StudentOrder;
import edu.register.peopleregister.domain.register.AnswerCityRegisterItem;
import edu.register.peopleregister.domain.register.CityRegisterResponse;
import edu.register.peopleregister.exception.CityRegisterException;
import edu.register.peopleregister.exception.TransportException;
import edu.register.peopleregister.validator.regists.CityRegisterChecker;
import edu.register.peopleregister.validator.regists.FakeCityRegisterChecker;


public class CityRegisterValidator {

    public static final String IN_CODE = "NO_GRN";

    private CityRegisterChecker personChecker;

    public CityRegisterValidator() {
        personChecker = new FakeCityRegisterChecker();
    }

    public AnswerCityRegister checkCityRegister(StudentOrder so) {
        AnswerCityRegister ans = new AnswerCityRegister();

            ans.addItem(checkPerson(so.getHusband()));
            ans.addItem(checkPerson(so.getWife()));
            for (Child child : so.getChildren()) {
                ans.addItem(checkPerson(child));
            }

        return ans;
    }

    private AnswerCityRegisterItem checkPerson(Person person) {
        AnswerCityRegisterItem.CityStatus status = null;
        AnswerCityRegisterItem.CityError error = null;
        try {
            CityRegisterResponse tmp = personChecker.checkPerson(person);
            status = tmp.isExisting()
                    ? AnswerCityRegisterItem.CityStatus.YES
                    : AnswerCityRegisterItem.CityStatus.NO;
        } catch (CityRegisterException | TransportException e) {
            e.printStackTrace();
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            if (e instanceof CityRegisterException ex) {
                error = new AnswerCityRegisterItem.CityError(ex.getCode(), e.getMessage());
            }
            if (e instanceof TransportException ex) {
                error = new AnswerCityRegisterItem.CityError(IN_CODE, e.getMessage());
            }
        }
        return new AnswerCityRegisterItem(status, person, error);
    }
}
