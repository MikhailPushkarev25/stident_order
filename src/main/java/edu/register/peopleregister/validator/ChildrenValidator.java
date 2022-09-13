package edu.register.peopleregister.validator;

import edu.register.peopleregister.domain.children.AnswerChildren;
import edu.register.peopleregister.domain.StudentOrder;

public class ChildrenValidator {

     public AnswerChildren checkChildren(StudentOrder so) {
        System.out.println("Children check is running");
        return new AnswerChildren();
    }
}
