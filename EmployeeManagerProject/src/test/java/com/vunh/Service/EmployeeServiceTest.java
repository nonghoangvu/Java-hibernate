package com.vunh.Service;

import com.vunh.Model.Employees;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest{
    private final  EmployeeService s = new EmployeeService();
    @Test
    void insertEmployee() {EmployeeService service = new EmployeeService();
        EmployeeService s = new EmployeeService();
        Employees employees = new Employees();
        employees.setEmployeeId(5);
        employees.setFirstName("Vu");
        employees.setLastName("Nong");
        employees.setDepartment("IT");
        employees.setPosition("Dev");
        employees.setSalary(100f);
        assertEquals(true, s.insertEmployee(employees));
    }

    @Test
    void testDelete(){
        assertEquals(true, this.s.deleteEmployee(20));
    }
}