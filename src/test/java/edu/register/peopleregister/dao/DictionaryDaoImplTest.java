package edu.register.peopleregister.dao;

import edu.register.peopleregister.domain.CountryArea;
import edu.register.peopleregister.domain.PassportOffice;
import edu.register.peopleregister.domain.RegisterOffice;
import edu.register.peopleregister.domain.Street;
import edu.register.peopleregister.exception.DaoException;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.List;

public class DictionaryDaoImplTest {

    private static final Logger logger = LoggerFactory.getLogger(DictionaryDaoImplTest.class);

    @BeforeClass
    public static void startUp() throws Exception {
        DbInit.startUp();

    }

    @Test
    public void testStreet() throws DaoException {
        LocalDateTime dt1 = LocalDateTime.now();
        LocalDateTime dt2 = LocalDateTime.now();
        logger.info("TEST {} {}",  dt1, dt2);
        List<Street> d = new DictionaryDaoImpl().findStreets("");
        Assert.assertTrue(d.size() == 5);
    }

    @Test
    public void testPassportOffice() throws DaoException {
        List<PassportOffice> po = new DictionaryDaoImpl().findPassportOffices("010020000000");
        Assert.assertTrue(po.size() == 1);
    }

    @Test
    public void testRegisterOffice() throws DaoException {
        List<RegisterOffice> ro = new DictionaryDaoImpl().findRegisterOffices("020020020000");
        Assert.assertTrue(ro.size() == 1);
    }

    @Test
    public void testArea() throws DaoException {
        List<CountryArea> ca1 = new DictionaryDaoImpl().findAreas("");
        Assert.assertTrue(ca1.size() == 2);
        List<CountryArea> ca2 = new DictionaryDaoImpl().findAreas("020000000000");
        Assert.assertTrue(ca2.size() == 2);
        List<CountryArea> ca3 = new DictionaryDaoImpl().findAreas("020010000000");
        Assert.assertTrue(ca3.size() == 2);
        List<CountryArea> ca4 = new DictionaryDaoImpl().findAreas("020010010000");
        Assert.assertTrue(ca4.size() == 2);
    }
}