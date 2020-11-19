package payroll.repositories;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import payroll.entities.Employee;

/*
 * priya: domain type as Employee and the id type as Long
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
