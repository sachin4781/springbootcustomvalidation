package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Employeecontroller {

    @Autowired
    EmployeeService employeeServiceImpl;


    @PostMapping("/signup")
    public ResponseEntity<Employee> signup(@Valid @RequestBody Employee employee) {
        return new ResponseEntity<>(employeeServiceImpl.signup(employee), HttpStatus.CREATED);
    }

    @GetMapping("/getdatabyid/{empid}")

    public ResponseEntity<Optional<Employee>> getdatabyid(int empid) {
        return ResponseEntity.ok(employeeServiceImpl.getdatabyid(empid));
    }

    @GetMapping("/getdatabyname/{empfirstname}")
    public ResponseEntity<List<Employee>> getdatabyname(@PathVariable String empfirstname) {
        return ResponseEntity.ok(employeeServiceImpl.getdatabyname(empfirstname));
    }


    @GetMapping("/getalldata")
    public ResponseEntity<List<Employee>> getalldata() {
        return ResponseEntity.ok(employeeServiceImpl.getalldata());
    }

    @PutMapping("/updatedata/{empid}")
    public ResponseEntity<Employee> updatedata(@RequestBody Employee employee, @Valid @PathVariable int empid) {

        Employee employee1 = employeeServiceImpl.getdatabyid(empid).orElseThrow(() -> new RecordNotFoundException("Employee Id Does Not Exist.."));

        employee1.setEmpfirstname(employee.getEmpfirstname());
        employee1.setEmplastname(employee.getEmplastname());
        employee1.setEmpsalary(employee.getEmpsalary());
        employee1.setEmpdob(employee.getEmpdob());
        employee1.setEmpemailid(employee.getEmpemailid());
        employee1.setEmppassword(employee.getEmppassword());
        employee1.setEmpaddress(employee.getEmpaddress());
        employee1.setEmpcontactnumber(employee.getEmpcontactnumber());

        return new ResponseEntity<>(employeeServiceImpl.updatedata(employee1), HttpStatus.CREATED);


    }

    @DeleteMapping("/deletedatabyid/{empid}")
    public ResponseEntity<String> deletedatabyid(@PathVariable int empid) {
        employeeServiceImpl.deletedatabyid(empid);
        return ResponseEntity.ok("Data Deleted SuccessFully..");
    }


}
