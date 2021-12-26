package com.example.springbootrest.dao;

import com.example.springbootrest.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAll() {
        TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e", Employee.class);

        return query.getResultList();
    }

    @Override
    public void save(Employee employee) {
        Employee entity = entityManager.merge(employee);
        employee.setId(entity.getId());
    }

    @Override
    public Employee get(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void delete(int id) {
        Query query = entityManager.createQuery("delete from Employee where id = :employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
