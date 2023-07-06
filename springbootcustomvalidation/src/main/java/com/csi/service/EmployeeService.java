package com.csi.service;

import com.csi.dao.EmployeeDaoImpl;
import com.csi.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    EmployeeDaoImpl employeeDaoImpl;


    public Employee signup(Employee employee) {

        return employeeDaoImpl.signup(employee);
    }

    @Cacheable(value = "empid")
    public Optional<Employee> getdatabyid(int empid) {

        log.info("$$$$$$$$$ Fetching Data From Db");
        return employeeDaoImpl.getdatabyid(empid);
    }

    public List<Employee> getdatabyname(String empfirstname) {
        return employeeDaoImpl.getdatabyname(empfirstname);
    }

    public List<Employee> getalldata() {
        return employeeDaoImpl.getalldata();
    }

    public Employee updatedata(Employee employee) {
        return employeeDaoImpl.updatedata(employee);
    }

    public void deletedatabyid(int empid) {
        employeeDaoImpl.deletedatabyid(empid);
    }


}
