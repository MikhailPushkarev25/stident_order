package edu.register.peopleregister;

import edu.register.peopleregister.dao.StudentOrderDao;
import edu.register.peopleregister.dao.StudentOrderDaoImpl;
import edu.register.peopleregister.domain.*;

import java.time.LocalDate;
import java.util.List;

public class SaveStudentOrder {

    public static void main(String[] args) throws Exception {

//        List<Street> d = new DictionaryDaoImpl().findStreets("");
//        for (Street s : d) {
//            System.out.println(s.getStreetName());
//        }
//
//        List<PassportOffice> po = new DictionaryDaoImpl().findPassportOffices("020020000000");
//        for (PassportOffice p : po) {
//            System.out.println(p.getOfficeName());
//        }
//
//        List<RegisterOffice> ro = new DictionaryDaoImpl().findRegisterOffices("020020020000");
//        for (RegisterOffice r : ro) {
//            System.out.println(r.getOfficeName());
//        }

//        List<CountryArea> ca1 = new DictionaryDaoImpl().findAreas("");
//        for (CountryArea c : ca1) {
//            System.out.println(c.getAreaId() + ": " + c.getAreaName());
//        }
//        System.out.println("------------------>");
//        List<CountryArea> ca2 = new DictionaryDaoImpl().findAreas("020000000000");
//        for (CountryArea c : ca2) {
//            System.out.println(c.getAreaId() + ": " + c.getAreaName());
//        }
//        System.out.println("------------------>");
//        List<CountryArea> ca3 = new DictionaryDaoImpl().findAreas("020010000000");
//        for (CountryArea c : ca3) {
//            System.out.println(c.getAreaId() + ": " + c.getAreaName());
//        }
//        System.out.println("------------------>");
//        List<CountryArea> ca4 = new DictionaryDaoImpl().findAreas("020010010000");
//        for (CountryArea c : ca4) {
//            System.out.println(c.getAreaId() + ": " + c.getAreaName());
//        }

//        StudentOrder so = new StudentOrder();
//        long ans = saveStudentOrder(so);
//        System.out.println(ans);

//        StudentOrder so = buildStudentOrder(10);
          StudentOrderDao dao = new StudentOrderDaoImpl();
//        Long id = dao.saveStudentOrder(so);
//        System.out.println(id);

        List<StudentOrder> soList = dao.getStudentOrders();
        for (StudentOrder studentOrder : soList) {
            System.out.println(studentOrder.getStudentOrderId());
        }

    }

    static long saveStudentOrder(StudentOrder so) {
        long answer = 199;
        System.out.println("saveStudentOrder 1");
        return answer;
    }

    public static StudentOrder buildStudentOrder(long id) {
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

    static void printStudentOrder(StudentOrder stOr) {
        System.out.println(stOr.getStudentOrderId());
    }
}
