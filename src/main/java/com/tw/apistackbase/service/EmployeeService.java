package com.tw.apistackbase.service;

import com.tw.apistackbase.dao.EmployeeDao;
import com.tw.apistackbase.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements EmployeeDao {

    public List<Employee> employeeList = new ArrayList<>();

    public EmployeeService(){
        employeeList.add(new Employee(0,"Xiaoming",20,"男"));
        employeeList.add(new Employee(1,"Xiaoming",19,"女"));
        employeeList.add(new Employee(2,"Xiaozhi",15,"男"));
        employeeList.add(new Employee(3,"Xiaogang",16,"男"));
        employeeList.add(new Employee(4,"Xiaoxia",15,"女"));
    }

    @Override
    public Employee getEmployeeById(int id) {
        List<Employee> employees =  employeeList.stream().filter(employee1 -> id == employee1.getId()).collect(Collectors.toList());

        return employees.size() > 0 ? employees.get(0) : null;
    }

    @Override
    public List<Employee> findAll() {
        return employeeList;
    }

    @Override
    public List<Employee> findAll(int ageMini) {
        return employeeList.stream().filter(employee -> employee.getAge() > ageMini ).collect(Collectors.toList());
    }

    @Override
    public boolean insert(Employee employee) {
        if(employeeList.contains(employee)){
            return false;
        }
        employeeList.add(employee);
        return true;
    }

    @Override
    public boolean update(Employee employee) {
        List<Employee> employees =  employeeList.stream().filter(employee1 -> employee.equals(employee1)).collect(Collectors.toList());
        if(employees.size() > 0){
            employees.get(0).update(employee);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        List<Employee> employees =  employeeList.stream().filter(employee1 -> id == employee1.getId()).collect(Collectors.toList());
        if(employees.size() > 0){
            employeeList.remove(employees.get(0));
            return true;
        }
        return false;
    }
    
}
