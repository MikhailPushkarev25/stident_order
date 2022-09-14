package edu.register.peopleregister;

import edu.register.peopleregister.dao.StudentOrderDao;
import edu.register.peopleregister.dao.StudentOrderDaoImpl;
import edu.register.peopleregister.domain.*;

import java.time.LocalDate;
import java.util.List;

public class SaveStudentOrder {

    static long saveStudentOrder(StudentOrder so) {
        long answer = 199;
        System.out.println("saveStudentOrder 1");
        return answer;
    }

    static void printStudentOrder(StudentOrder stOr) {
        System.out.println(stOr.getStudentOrderId());
    }
}
