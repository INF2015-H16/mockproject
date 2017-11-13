/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mockexemple;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import mockexemple.Employee;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author zzaier
 */


public class EmployeeTest {

    protected SimpleDateFormat formater;

    @Before
    public void setUp() throws ParseException {
        formater = new SimpleDateFormat("dd/MM/yyyy");
    }

    @Test
    public void testGetPermaCode() throws ParseException {
        System.out.println("getPermaCode");

        Employee instance = new Employee("Pacal", "Jean", formater.parse("10/11/1977"));
        String expResult = "PACJ771110";
        String result = instance.getEmployeeNumber();
        assertEquals(expResult, result);

        instance = new Employee("Zaier", "Zied", formater.parse("02/03/1977"));
        expResult = "ZAIZ770302";
        result = instance.getEmployeeNumber();
        assertEquals(expResult, result);

        instance = new Employee("Martin", "Rose", formater.parse("11/08/1979"));
        expResult = "MARR790811";
        result = instance.getEmployeeNumber();
        assertEquals(expResult, result);
    }

    @Ignore
    public void testGetAge() throws ParseException {
        System.out.println("getAge");

        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        Integer thisYear = Integer.parseInt(yearFormat.format(new Date()));

        Integer age = 21;

        Date birthDate = formater.parse("02/03/" + (thisYear - age));
        Employee instance = new Employee("Zaier", "Zied", birthDate);

        Integer expResult = age;
        Integer result = instance.getEmployeeAge();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetScore() throws ParseException {
        System.out.println("getScore");

        Employee testee = new Employee("Zaier", "Zied", formater.parse("23/11/1983"));

        testee.setHoursPerProject("Web App", 85.0);
        testee.setHoursPerProject("Mobile App", 80.0);

        Double result = testee.getHoursPerProject("Web App");
        assertEquals(result, (Double) 85.0);

        result = testee.getHoursPerProject("Mobile App");
        assertEquals(result, (Double) 80.0);

        result = testee.getHoursPerProject("Desktop APP");
        assertNull(result);
    }

    @Test
    public void testSetScore() throws ParseException {
        System.out.println("setScore");

        Employee testee = new Employee("Zaier", "Zied", formater.parse("23/11/1983"));

        testee.setHoursPerProject("Web App", 85.0);
        assertFalse(testee.hoursPerProject.isEmpty());
    }

    @Test
    public void testGetAverageHoursPerProject() throws ParseException {
        System.out.println("getAverageScore");

        Employee testee = new Employee("Zaier", "Zied", formater.parse("13/12/1977"));

        testee.setHoursPerProject("Web App", 85.0);
        testee.setHoursPerProject("Mobile App", 80.0);

        Double expResult = (Double) 82.5;
        Double result = testee.getAverageHoursPerProject();
        assertEquals(expResult, result);
    }
}