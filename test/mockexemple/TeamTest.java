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
import mockexemple.Team;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
/**
 *
 * @author zzaier
 */


public class TeamTest {

    protected SimpleDateFormat formater;
    protected Team testee;

    @Before
    public void setUp() {
        formater = new SimpleDateFormat("dd/MM/yyyy");
        testee = new Team();
    }

    @Test
    public void testAddEmployeeAgrgs() {
        System.out.println("addEmployee");

        String lastname = "Zaier";
        String firstname = "Zied";
        Date dob = new Date();

        testee.addEmployee(lastname, firstname, dob);
        assertEquals(testee.getEmployees().size(), 1);
    }

    @Test
    public void testAddEmployeeObject() throws ParseException {
        System.out.println("addEmployee");

        Employee student = new Employee("Zaier", "Zied", new Date());

        testee.addEmployee(student);
        assertEquals(testee.getEmployees().size(), 1);
    }

    @Test
    public void testGetStudentByPermaCode() throws ParseException {
        System.out.println("getEmployeeByEmployeeNumber");

        Employee student = new Employee("Zaier", "Zied", formater.parse("12/12/1977"));
        String permaCode = student.getEmployeeNumber();

        testee.addEmployee(student);

        Employee result = testee.getEmployeeByEmployeeNumber(permaCode);
        assertEquals(student, result);

        result = testee.getEmployeeByEmployeeNumber("XXXX111111");
        assertNull(result);
    }

    @Test
    public void testGetGroupAverage() {
        System.out.println("getTeamAverageHoursPerProject");

        Employee employee1 = new Employee("Zaier", "Zied", new Date());
        employee1.setHoursPerProject("Mobile App", 70.0);
        employee1.setHoursPerProject("WEB App", 50.0);
        testee.addEmployee(employee1);

        Employee employee2 = new Employee("Hebou", "Jin", new Date());
        employee2.setHoursPerProject("Mobile App", 30.0);
        employee2.setHoursPerProject("WEB App", 120.0);
        testee.addEmployee(employee2);

        Employee employee3 = new Employee("Rose", "Pascal", new Date());
        employee3.setHoursPerProject("Mobile App", 60.0);
        employee3.setHoursPerProject("WEB App", 30.0);
        testee.addEmployee(employee3);

        Double sum = employee1.getAverageHoursPerProject() + employee2.getAverageHoursPerProject() + employee3.getAverageHoursPerProject();
        Double expResult = sum / 3;
        Double result = testee.getTeamAverageHoursPerProject();
        assertEquals(expResult, result);
    }
}