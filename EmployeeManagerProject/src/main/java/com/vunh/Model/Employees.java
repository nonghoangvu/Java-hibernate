package com.vunh.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "Employees")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employees {
    @Id
    @Column(name = "EmployeeID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "Department")
    private String department;

    @Column(name = "Position")
    private String position;

    @Column(name = "Salary")
    private double salary;
}
