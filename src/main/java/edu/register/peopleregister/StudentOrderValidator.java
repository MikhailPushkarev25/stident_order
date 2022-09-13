package edu.register.peopleregister;

import edu.register.peopleregister.domain.*;
import edu.register.peopleregister.domain.children.AnswerChildren;
import edu.register.peopleregister.domain.register.AnswerCityRegister;
import edu.register.peopleregister.domain.student.AnswerStudent;
import edu.register.peopleregister.domain.wedding.AnswerWedding;
import edu.register.peopleregister.exception.CityRegisterException;
import edu.register.peopleregister.exception.TransportException;
import edu.register.peopleregister.mail.MailSander;
import edu.register.peopleregister.validator.*;

import java.util.LinkedList;
import java.util.List;

public class StudentOrderValidator {

    private CityRegisterValidator cityRegisterVal;
    private WeddingValidator weddingVal;
    private ChildrenValidator childrenVal;
    private StudentValidator studentVal;
    private MailSander mailSander;

    public StudentOrderValidator() {
        cityRegisterVal = new CityRegisterValidator();
        weddingVal = new WeddingValidator();
        childrenVal = new ChildrenValidator();
        studentVal = new StudentValidator();
        mailSander = new MailSander();
    }


    public static void main(String[] args) {
        StudentOrderValidator sov = new StudentOrderValidator();
        try {
            sov.checkAll();
        } catch (CityRegisterException e) {
            e.printStackTrace();
        } catch (TransportException e) {
            e.printStackTrace();
        }

    }

    public void checkAll() throws TransportException, CityRegisterException {

        List<StudentOrder> soList = readStudentOrders();

        for (StudentOrder so : soList) {
            oneCheckOrder(so);
        }

//        for(StudentOrder so : soArray) {
//            System.out.println();
//            oneCheckOrder(so);
//        }
    }

    public List<StudentOrder> readStudentOrders() {
        List<StudentOrder> soList = new LinkedList<>();

        for(int i = 0; i < 5; i++) {
            StudentOrder so = SaveStudentOrder.buildStudentOrder(i);
            soList.add(so);
        }
        return soList;
    }

    public void oneCheckOrder(StudentOrder so) {
        AnswerCityRegister cityAnswer = checkCityRegister(so);
//        AnswerWedding answerWedding = checkWedding(so);
//        AnswerChildren answerChildren = checkChildren(so);
//        AnswerStudent answerStudent = checkStudent(so);
//        sendMail(so);
    }

    public AnswerCityRegister checkCityRegister(StudentOrder so) {
       return cityRegisterVal.checkCityRegister(so);
    }

    public AnswerWedding checkWedding(StudentOrder so) {
       return weddingVal.checkWedding(so);
    }

    public AnswerChildren checkChildren(StudentOrder so) {
        return childrenVal.checkChildren(so);
    }

    public AnswerStudent checkStudent(StudentOrder so) {
        return studentVal.checkStudent(so);
    }

    public void sendMail(StudentOrder so) {
        mailSander.sendMail(so);
    }
}
