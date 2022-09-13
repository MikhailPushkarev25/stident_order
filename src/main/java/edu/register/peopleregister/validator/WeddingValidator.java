package edu.register.peopleregister.validator;

import edu.register.peopleregister.domain.wedding.AnswerWedding;
import edu.register.peopleregister.domain.StudentOrder;

public class WeddingValidator {

     public AnswerWedding checkWedding(StudentOrder so) {
        System.out.println("Wedding running");
        return new AnswerWedding();
    }
}
