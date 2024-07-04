package com.excelr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.entity.Employee;
import com.excelr.service.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService empService;

    // Adding a new employee
    @PostMapping("/emp")
    public ResponseEntity<Employee> add(@RequestBody Employee emp) {
        Employee emp1 = empService.insertEmp(emp);
        return ResponseEntity.status(HttpStatus.CREATED).body(emp1);
    }

    // Getting all employees
    @GetMapping("/allEmp")
    public ResponseEntity<List<Employee>> getAll() {
        List<Employee> list = empService.getAllEmp();
        return ResponseEntity.ok(list); // Using OK status for successful GET requests
    }

    // Updating an employee
    @PutMapping("/emp/{id}")
    public ResponseEntity<Employee> update(@PathVariable int id, @RequestBody Employee emp) {
        Employee emp1 = empService.updateEmp(id, emp);
        return ResponseEntity.status(HttpStatus.OK).body(emp1);
    }

    // Deleting an employee
    @DeleteMapping("/emp/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        empService.deleteEmp(id);
        return ResponseEntity.noContent().build(); // Returning No Content status for DELETE
    }
}

