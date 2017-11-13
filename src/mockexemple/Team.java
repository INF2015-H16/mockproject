/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mockexemple;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author zzaier
 */


public class Team {

    protected Map<String, Employee> employees;

    public Team() {
        this.employees = new HashMap<>();
    }

    public Collection<Employee> getEmployees() {
        return employees.values();
    }

    public void addEmployee(String lastName, String firstName, Date dob) {
        addEmployee(new Employee(lastName, firstName, dob));
    }

    public void addEmployee(Employee employee) {
        employees.put(employee.employeeNumber, employee);
    }

    public Employee getEmployeeByEmployeeNumber(String employeeNumber) {
        return employees.get(employeeNumber);
    }

    public Double getTeamAverageHoursPerProject() {
        Double sum = 0.0;
        for (Employee employee : employees.values()) {
            sum += employee.getAverageHoursPerProject();
        }
        return sum / employees.size();
    }
}

