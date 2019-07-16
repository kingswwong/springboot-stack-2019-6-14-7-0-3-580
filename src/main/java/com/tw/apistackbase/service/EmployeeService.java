package com.tw.apistackbase.service;

import com.tw.apistackbase.dao.EmployeeDao;
import com.tw.apistackbase.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService{

   @Autowired
   private EmployeeDao employeeDao;

    public Employee getEmployeeById(int id) {
        return employeeDao.getEmployeeById(id);
    }

    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    public List<Employee> findAll(int ageMini) {
        return employeeDao.findAll(ageMini);
    }


    public boolean insert(Employee employee) {
        return employeeDao.insert(employee);
    }

    public boolean update(Employee employee) {
        return employeeDao.update(employee);
    }

    public boolean delete(int id) {
        return employeeDao.delete(id);
    }
    
}
