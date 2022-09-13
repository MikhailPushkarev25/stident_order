package edu.register.peopleregister.validator;

import edu.register.peopleregister.domain.student.AnswerStudent;
import edu.register.peopleregister.domain.StudentOrder;

public class StudentValidator {

    public AnswerStudent checkStudent(StudentOrder so) {
        System.out.println("Student validate");
        return new AnswerStudent();
    }
}
