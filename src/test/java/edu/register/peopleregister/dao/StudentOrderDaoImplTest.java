package edu.register.peopleregister.dao;

import edu.register.peopleregister.domain.*;
import edu.register.peopleregister.exception.DaoException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class StudentOrderDaoImplTest {

    @BeforeClass
    public static void startUp() throws Exception {
        DbInit.startUp();

    }

    @Test
    public void saveStudentOrder() throws DaoException {
        StudentOrder so = buildStudentOrder(10);
        Long id = new StudentOrderDaoImpl().saveStudentOrder(so);
    }

    @Test(expected = DaoException.class)
    public void saveStudentOrderError() throws DaoException {
            StudentOrder so = buildStudentOrder(10);
            so.getHusband().setSurName(null);
            Long id = new StudentOrderDaoImpl().saveStudentOrder(so);
            Assert.fail("Error should be");
    }

    @Test
    public void getStudentOrders() throws DaoException {
       List<StudentOrder> list = new StudentOrderDaoImpl().getStudentOrders();

    }

    public StudentOrder buildStudentOrder(long id) {
        RegisterOffice ro = new RegisterOffice(1L, "area", "name");

        PassportOffice ps = new PassportOffice(1L, "area", "office name");

        Street street = new Street(1L, "First street");

        Address address = new Address("195000", street, "12", "", "142");

        StudentOrder so = new StudentOrder();
        so.setStudentOrderId(id);
        so.setMarriageCertificateId("" + (123456000 + id));
        so.setMarriageDate(LocalDate.of(2016, 7, 4));
        so.setMarriageOffice(ro);

        //муж
        Adult husband = new Adult("Petrov", "Viktor", "Sergeevich", LocalDate.of(1997, 8, 24));
        husband.setPassportSeria("" + (1000 + id));
        husband.setPassportNumber("" + (100000 + id));
        husband.setIssueDate(LocalDate.of(2017, 9, 15));
        husband.setIssueDepartment(ps);
        husband.setStudentId("" + (100000 + id));
        husband.setAddress(address);
        husband.setUniversity(new University(2L, ""));
        husband.setStudentId("HH12345");

        //жена
        Adult wife = new Adult("Petrova", "Elena", "Pavlovna", LocalDate.of(1995, 1, 10));
        wife.setPassportSeria("" + (2000 + id));
        wife.setPassportNumber("" + (200000 + id));
        wife.setIssueDate(LocalDate.of(2015, 4, 2));
        wife.setIssueDepartment(ps);
        wife.setStudentId("" + (200000 + id));
        wife.setAddress(address);
        wife.setUniversity(new University(1L, ""));
        wife.setStudentId("WW12345");

        //Ребенок 1
        Child child1 = new Child("Petrova", "Irina", "Viktorovna", LocalDate.of(2018, 6, 29));
        child1.setCertificateNumber("" + (300000 + id));
        child1.setIssueDate(LocalDate.of(2018, 6, 11));
        child1.setIssueDepartment(ro);
        child1.setAddress(address);

        //Ребенок 2
        Child child2 = new Child("Petrov", "Evgeny", "Viktorovich", LocalDate.of(2018, 6, 29));
        child2.setCertificateNumber("" + (400000 + id));
        child2.setIssueDate(LocalDate.of(2018, 7, 12));
        child2.setIssueDepartment(ro);
        child2.setAddress(address);

        so.setHusband(husband);
        so.setWife(wife);
        so.addChildren(child1);
        so.addChildren(child2);
        return so;
    }
}