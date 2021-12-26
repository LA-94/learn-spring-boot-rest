package com.example.springbootrest.dao;


import com.example.springbootrest.domain.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> getAll();

    void save(Employee employee);

    Employee get(int id);

    void delete(int id);
}
