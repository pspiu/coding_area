package com.example.accessingdatajpa;

import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class AccessingDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class, args);
	}
	
	/*
	 * priya: hardcoded (can be used if we do not have controller and service)
	 */

	Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

	@Autowired
	EmployeeRepository repository;
	
	/*
	 * or:
	 * @Bean
	 * public CommandLineRunner demo(EmployeeRepository repository) instead of autowiring
	 */
	@Bean
	public CommandLineRunner demo() {
		return (args) -> {
			// save a few customers
			repository.save(new Employee("Priya", "Developer"));
			repository.save(new Employee("Monika", "Scientist"));
			repository.save(new Employee("Prajwal", "Lawyer"));
			repository.save(new Employee("Dhiraj", "Investor"));
			repository.save(new Employee("Preeti", "Developer"));

			// fetch all customers
			log.info("Employees found with findAll():");
			log.info("-------------------------------");
			for (Employee customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual employee by ID
			Optional<Employee> customer = repository.findById(3l);
			log.info("Employee found with findById(3):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch employee by role
			log.info("Employee found with findByRole('Developer'):");
			log.info("--------------------------------------------");
			repository.findByRole("Developer").forEach(Developer -> {
				log.info(Developer.toString());
			});
			// for (Employee bauer : repository.findByRole("Developer")) {
			// log.info(bauer.toString());
			// }
			log.info("");
		};
	}
	
}
