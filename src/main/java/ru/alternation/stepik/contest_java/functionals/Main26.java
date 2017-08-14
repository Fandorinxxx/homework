package ru.alternation.stepik.contest_java.functionals;

import java.util.List;

/**
 2.26 The ﻿general number of employees


 You have two classes:
    Employee (name: String, salary: Long),
    Department (name: String, code: String, employees: List<Employee>).
 Both classes have getters for all fields with the corresponding names (getName(), getSalary(), getEmployees() and so on).

 TASK: write a method using Stream API that calculates the general number of employees with salary >= threshold for
 all departments whose code starts with string "111-" (without ""). Perhaps, flatMap method can help you to implement it.

 Classes Employee and Department will be available during testing. You can define your own classes for local testing.

 NOTE: Use the given template for your method. Pay attention to type of an argument and the returned value.
 Please, use only Stream API, no cycles.


 Example. There are 2 departments (in JSON notation) below and ﻿threshold = 20 000.
 The result is 1 (because there is only one suitable employee).

 [
    {
        "name": "dep-1",
        "code": "111-1",
        "employees": [
            {
                "name": "William",
                "salary": 20000
            },
            {
                "name": "Sophia",
                "salary": 10000
            }
          ]
    },
    {
        "name": "dep-2",
        "code": "222-1",
        "employees": [
            {
                "name": "William",
                "salary": 50000
            }
        ]
    }
 ]﻿﻿

 */
public class Main26 {
    /**
     * Calculates the number of employees with salary >= threshold (only for 111- departments)
     *
     * @param departments are list of departments
     * @param threshold is lower edge of salary
     *
     * @return numbers of employees that match the conditions
     */
    public static long calcNumberOfEmployees(List<Department> departments, long threshold) {
        return departments.stream()
                .filter(department -> department.getCode().startsWith("111-"))
                .map(Department::getEmployees)
                .flatMap(List::stream)
                .filter(employee -> employee.getSalary() >= threshold)
                .count();
    }

    public static void main(String[] args) {

    }

    static class Department {
        private String name;
        private String code;
        private List<Employee> employees;

        public String getName() {
            return name;
        }

        public String getCode() {
            return code;
        }

        public List<Employee> getEmployees() {
            return employees;
        }
    }

    static class Employee {
        private String name;
        private Long salary;

        public String getName() {
            return name;
        }

        public Long getSalary() {
            return salary;
        }
    }
}
