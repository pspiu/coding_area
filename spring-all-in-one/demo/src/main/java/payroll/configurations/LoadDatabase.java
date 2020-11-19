package payroll.configurations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;

import payroll.entities.Employee;
import payroll.entities.Order;
import payroll.repositories.EmployeeRepository;
import payroll.repositories.OrderRepository;
import payroll.utils.Status;

@Configuration
class LoadDatabase {
	@Autowired
	EmployeeRepository repository;

	@Autowired
	OrderRepository orderRepository;

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase() {

		return args -> {
			log.info("Preloading " + repository.save(new Employee("Bilbo", "Baggins", "burglar")));
			log.info("Preloading " + repository.save(new Employee("Frodo", "Baggins", "thief")));
			log.info("Preloading " + repository.save(new Employee("Dhiraj", "Gupta", "investor")));
			log.info("Preloading " + repository.save(new Employee("Priya", "Singh", "developer")));
			log.info("Preloading " + repository.save(new Employee("Monkia", "Singh", "developer")));
			log.info("Preloading " + repository.save(new Employee(" Prajwal", "Singh", "lawyer")));
			log.info("Preloading " + repository.save(new Employee("Anamika", "Agrawak", "devops")));
			log.info("Preloading " + repository.save(new Employee("Sangeeta", "Bansal", "teacher")));
			log.info("Preloading " + repository.save(new Employee("Vandana", "Nair", "self")));

			orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
			orderRepository.save(new Order("iPhone", Status.IN_PROGRESS));
			orderRepository.findAll().forEach(order -> {
				log.info("Preloaded " + order);
			});
		};

	}
}
