package com.tw.apistackbase.dao;

import com.tw.apistackbase.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee getEmployeeById(int id);
    List<Employee> findAll();
    boolean insert(Employee employee);
    boolean update(Employee employee);
    boolean delete(int id);
}