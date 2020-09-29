package com.example.accessingdatajpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class EmployeeService {

	Logger log = LoggerFactory.getLogger(EmployeeService.class);
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployees() {
		log.info("Employees found with findAll():");
		log.info("-------------------------------");
		for (Employee customer : employeeRepository.findAll()) {
			log.info(customer.toString());
		}
		log.info("");
		List<Employee> emp = new ArrayList<Employee>();
		employeeRepository.findAll().forEach(emp::add);
		
		return emp;
	}

	public Optional<Employee> getEmployeeById(Long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		log.info("Employee found with findById():");
		log.info("--------------------------------");
		log.info(employee.toString());
		log.info("");
		return employeeRepository.findById(id);
	}

	public Optional<List<Employee>> getByRole(String role) {
		Optional<List<Employee>> employee = Optional.ofNullable(employeeRepository.findByRole(role));
		log.info("Employee found with findByRole():");
		log.info("--------------------------------");
		log.info(employee.toString());
		log.info("");
		List<Employee> emp = new ArrayList<Employee>();
		employeeRepository.findByRole(role).forEach(emp::add);
		return Optional.ofNullable(emp);
	}

	@ResponseBody
	public void addEmployee(Employee e) {
		employeeRepository.save(e);
	}

	public void remove(Long id) {
		employeeRepository.deleteById(id);
	}

}
