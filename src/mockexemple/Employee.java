/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mockexemple;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author zzaier
 */


public class Employee {

    protected Map<String, Double> hoursPerProject;
    protected String employeeNumber;
    protected Integer employeeAge;

    public Employee(String lastName, String firstName, Date dob) {
        this.hoursPerProject = new HashMap<>();
        this.employeeNumber = buildEmployeeNumber(lastName, firstName, dob);
        this.employeeAge = convertDateToAge(dob);
    }

    private String buildEmployeeNumber(String lastName, String firstName, Date dob) {
        SimpleDateFormat formater = new SimpleDateFormat("yyMMdd");
        return lastName.substring(0, 3).toUpperCase() + firstName.substring(0, 1).toUpperCase() + formater.format(dob);
    }

    //FIXME : très mauvaise implémentation qui ne prend pas en compte le jour dans l'année
    public Integer convertDateToAge(Date dob) {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy");
        int currentYear = Integer.parseInt(formater.format(new Date()));
        int dobYear = Integer.parseInt(formater.format(dob));
        return currentYear - dobYear;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public Integer getEmployeeAge() {
        return employeeAge;
    }

    public void setHoursPerProject(String project, Double hours) {
        this.hoursPerProject.put(project, hours);
    }

    public Double getHoursPerProject(String project) {
        return this.hoursPerProject.get(project);
    }

    public Double getAverageHoursPerProject() {
        Double sum = 0.0;
        for (Double project : hoursPerProject.values()) {
            sum += project;
        }
        return sum / hoursPerProject.size();
    }
}
