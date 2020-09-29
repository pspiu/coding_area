package com.example.accessingdatajpa;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService es;

	@GetMapping(value = "/employee")
	public List<Employee> getEmployee() {
		return es.getAllEmployees();
	}
	
	@GetMapping(value="/employee/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable Long id) {
		return es.getEmployeeById(id);		
	}

	@GetMapping(value = "/employee/{id}/{role}")
	public Optional<List<Employee>> getEmmployeeById(@PathVariable String role) {
		return es.getByRole(role);
	}

	@PostMapping(value = "/employee")
	public void addEmplyee(@RequestBody Employee e) {
		es.addEmployee(e);
	}

	@DeleteMapping(value = "/employee/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		es.remove(id);

	}

}
