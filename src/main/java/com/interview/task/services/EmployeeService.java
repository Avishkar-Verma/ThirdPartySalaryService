package com.interview.task.services;

import com.interview.task.repository.EmployeeRepository;
import com.interview.task.repository.entity.EmployeeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public int getSalary(int employeeId) {
        Optional<EmployeeDetails> employeeDetails = employeeRepository.findById(employeeId);
        if (employeeDetails.isPresent()) {
            return employeeDetails.get().getSalary();
        }
        return 0;
    }
}
