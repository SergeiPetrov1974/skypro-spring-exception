package pro.sky.course2.skyprospringexception.service;

import pro.sky.course2.skyprospringexception.data.Employee;

public interface EmployeeService {
    String add(String firstName, String secondName);
    String remove(String firstName, String secondName);
    Employee find(String firstName, String secondName);
}
