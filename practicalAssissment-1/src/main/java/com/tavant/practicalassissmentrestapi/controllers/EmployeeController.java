package com.tavant.practicalassissmentrestapi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.DomainEvents;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tavant.practicalassissmentrestapi.exception.ResourceNotFoundException;
import com.tavant.practicalassissmentrestapi.models.Employee;
import com.tavant.practicalassissmentrestapi.repository.EmployeeRepository;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/")

public class EmployeeController {
        @Autowired
        EmployeeRepository employeeRepository;
        
        //(http://localhost:8080/api/all)
        @GetMapping("/all")
        public List<Employee> getAllEmployee(){
        	return employeeRepository.findAll();
        }
        
        
        //(http://localhost:8080/api/employee)
        @PostMapping("/employee")
        public Employee createEmployee(@RequestBody @Valid Employee employee) {
			return employeeRepository.save(employee);
        	
        }
        
        
      //(http://localhost:8080/api/id)
        
        @DeleteMapping("/{id}")
        public void deleteEmployee(@PathVariable Long id) {
        	this.employeeRepository.deleteById(id);
        }
        
        
        
        //(http://localhost:8080/api/update/id)
        @PutMapping("/update/{id}")
        public ResponseEntity<Employee> updateEmployee(@PathVariable Long employeeId ,@Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException{
        	Employee  employee=employeeRepository.findById(employeeId).orElseThrow(()->new
        			ResourceNotFoundException("employee not found"+employeeId));
        	employee.setEmail(employeeDetails.getEmail());
        	employee.setFirstName(employeeDetails.getFirstName());
        	employee.setLastName(employeeDetails.getLastName());
			final Employee updateEmployee=employeeRepository.save(employee);
			return ResponseEntity.ok(updateEmployee);
        	
        }
        
}
