package com.interview.task.controller;

import com.interview.task.repository.entity.EmployeeDetails;
import com.interview.task.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class EmployeeSalaryController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getEmployeeSalary")
    public ResponseEntity<Object> getSalaryOfEmployee(@RequestParam(name="employee_id") int id) throws ExecutionException, InterruptedException {
        int salary = employeeService.getSalary(id);
        return salary > 0 ? ResponseEntity.ok(salary) : ResponseEntity.status(404).body("Employee id is invalid");
    }
}
