package org.serial.Employee;

import java.io.Serializable;

public class Employee implements Serializable  {

    private String name;
    private int employeeid;

    public Employee(String name, int employeeid) {

        this.name = name;
        this.employeeid = employeeid;

    }

    public String getName() {

        return this.name;
    }

    public int getEmployeeid() {

        return employeeid;
    }
}
