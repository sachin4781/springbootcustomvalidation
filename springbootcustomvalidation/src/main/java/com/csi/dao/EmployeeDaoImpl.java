package com.csi.dao;

import com.csi.model.Employee;
import com.csi.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeDaoImpl {

    @Autowired
    EmployeeRepository employeeRepositoryImpl;


    public Employee signup(Employee employee) {

        return employeeRepositoryImpl.save(employee);
    }


    public Optional<Employee> getdatabyid(int empid) {
        return employeeRepositoryImpl.findById(empid);
    }

    public List<Employee> getdatabyname(String empfirstname) {
        return employeeRepositoryImpl.findByempfirstname(empfirstname);
    }

    public List<Employee> getalldata() {
        return employeeRepositoryImpl.findAll();
    }

    public Employee updatedata(Employee employee) {
        return employeeRepositoryImpl.save(employee);
    }

    public void deletedatabyid(int empid) {
        employeeRepositoryImpl.deleteById(empid);
    }


}
