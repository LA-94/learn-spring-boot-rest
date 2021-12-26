package com.example.springbootrest.service;

import com.example.springbootrest.domain.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAll();

    void save(Employee employee);

    Employee get(int id);

    void delete(int id);
}
