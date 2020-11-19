package payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import payroll.entities.Employee;
import payroll.repositories.EmployeeRepository;

/*
 * priya: Note that your Driver class should be at the base package provided in build.gradle ; eg: group = 'payroll'
 */

@SpringBootApplication
public class SpringAllInOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAllInOneApplication.class, args);
	}
}

/*
 * priya: curl eg: Windows cmd: curl -X POST localhost:8087/employees -H
 * "Content-type:application/json" -d
 * "{\"name\": \"Nikita\", \"role\":\"professor\"}" others: curl -X POST
 * localhost:8087/employees -H 'Content-type:application/json' -d '{"name":
 * "Nikita", "role":"professor"}'
 */