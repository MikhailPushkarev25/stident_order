package edu.register.peopleregister.dao;

import edu.register.peopleregister.domain.StudentOrder;
import edu.register.peopleregister.exception.DaoException;

import java.util.List;

public interface StudentOrderDao {

    Long saveStudentOrder(StudentOrder so) throws DaoException;

    List<StudentOrder> getStudentOrders() throws DaoException;
}
