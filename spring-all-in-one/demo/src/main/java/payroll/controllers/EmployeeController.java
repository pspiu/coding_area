package payroll.controllers;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import payroll.entities.Employee;
import payroll.exceptions.EmployeeNotFoundException;
import payroll.modelAssembler.EmployeeModelAssembler;
import payroll.repositories.EmployeeRepository;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

/*
 * priya:@RestController indicates that the data returned by each method 
 * will be written straight into the response body instead of rendering a template.
 */
@RestController
public class EmployeeController {

	private final EmployeeRepository repository;
	private final EmployeeModelAssembler assembler;

	EmployeeController(EmployeeRepository repository, EmployeeModelAssembler assembler) {
		this.repository = repository;
		this.assembler = assembler;
	}

	/*
	 * priya: try curl: curl -v http://localhost:8087/employees | json_pp
	 */
	/*
	 * CollectionModel<> is another Spring HATEOAS container aimed at encapsulating
	 * collections. It, too, also lets you include links
	 */

	/*
	 * w/o EMA
	 * 
	 * @GetMapping("/employees") public CollectionModel<EntityModel<Employee>>
	 * all_old() {
	 * 
	 * List<EntityModel<Employee>> employees = repository.findAll().stream()
	 * .map(employee -> EntityModel.of(employee,
	 * linkTo(methodOn(EmployeeController.class).one(employee.getId())).withSelfRel(
	 * ), linkTo(methodOn(EmployeeController.class).all()).withRel("employees")))
	 * .collect(Collectors.toList());
	 * 
	 * return CollectionModel.of(employees,
	 * linkTo(methodOn(EmployeeController.class).all()).withSelfRel()); }
	 */

	// with RMA
	@GetMapping("/employees")
	public CollectionModel<EntityModel<Employee>> all() {
		List<EntityModel<Employee>> employees = repository.findAll().stream().map(assembler::toModel)
				.collect(Collectors.toList());

		return CollectionModel.of(employees, linkTo(methodOn(EmployeeController.class).all()).withSelfRel());
	}

	/*
	 * @PostMapping("/employees") Employee newEmployee_old(@RequestBody Employee
	 * newEmployee) { return repository.save(newEmployee); }
	 */

	// try curl -v -X POST localhost:8080/employees -H
	// 'Content-Type:application/json' -d '{"name": "Samwise Gamgee", "role":
	// "gardener"}'
	@PostMapping("/employees")
	ResponseEntity<?> newEmployee(@RequestBody Employee newEmployee) {
		EntityModel<Employee> entityModel = assembler.toModel(repository.save(newEmployee));

		return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
	}
	/*
	 * EntityModel<T> is a generic container from Spring HATEOAS that includes not
	 * only the data but a collection of links.
	 */
	/*
	 * priya:linkTo(methodOn(EmployeeController.class).one(id)).withSelfRel() asks
	 * that Spring HATEOAS build a link to the EmployeeController 's one() method,
	 * and flag it as a self link.
	 * 
	 * linkTo(methodOn(EmployeeController.class).all()).withRel("employees") asks
	 * Spring HATEOAS to build a link to the aggregate root, all(), and call it
	 * "employees".
	 */

	/*
	 * w/o RepresentationModelAssembler
	 * 
	 * @GetMapping("/employees/{id}") public EntityModel<Employee>
	 * one_old(@PathVariable Long id) { Employee employee =
	 * repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
	 * return EntityModel.of(employee,
	 * linkTo(methodOn(EmployeeController.class).one(id)).withSelfRel(),
	 * linkTo(methodOn(EmployeeController.class).all()).withRel("employees")); }
	 */

	// with RepresentationModelAssembler Interface (EmployeeModelAssembler)
	@GetMapping("/employees/{id}")
	public EntityModel<Employee> one(@PathVariable Long id) {

		Employee employee = repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));

		return assembler.toModel(employee);
	}

	/*
	 * @PutMapping("/employees/{id}") public Employee replaceEmployee(@RequestBody
	 * Employee newEmployee, @PathVariable Long id) {
	 * 
	 * return repository.findById(id).map(employee -> {
	 * employee.setName(newEmployee.getName());
	 * employee.setRole(newEmployee.getRole()); return repository.save(employee);
	 * }).orElseGet(() -> { newEmployee.setId(id); return
	 * repository.save(newEmployee); }); }
	 */
	@PutMapping("/employees/{id}")
	ResponseEntity<?> replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

		Employee updatedEmployee = repository.findById(id).map(employee -> {
			employee.setName(newEmployee.getName());
			employee.setRole(newEmployee.getRole());
			return repository.save(employee);
		}).orElseGet(() -> {
			newEmployee.setId(id);
			return repository.save(newEmployee);
		});

		EntityModel<Employee> entityModel = assembler.toModel(updatedEmployee);

		return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
	}

	/*
	 * @DeleteMapping("/employees/{id}") void deleteEmployee(@PathVariable Long id)
	 * { repository.deleteById(id); }
	 */
	@DeleteMapping("/employees/{id}")
	ResponseEntity<?> deleteEmployee(@PathVariable Long id) {

		repository.deleteById(id);

		return ResponseEntity.noContent().build();
	}
}

/*
 * priya: Spring HATEOAS: a Spring project aimed at helping you write
 * hypermedia-driven outputs. To upgrade your service to being RESTful, add this
 * to your build: implementation
 * 'org.springframework.boot:spring-boot-starter-hateoas' For Spring MVC and
 * 
 * Uses the static helper methods from WebMvcLinkBuilder to build these links.
 * If you are using Spring WebFlux in your project, you must instead use
 * WebFluxLinkBuilder.
 */

/*
 * Enter HATEOAS or Hypermedia as the Engine of Application State. Instead of
 * clients parsing the payload, give them links to signal valid actions.
 * Decouple state-based actions from the payload of data. In other words, when
 * CANCEL and COMPLETE are valid actions, dynamically add them to the list of
 * links. Clients only need show users the corresponding buttons when the links
 * exist.This decouples clients from having to know WHEN such actions are valid,
 * reducing the risk of the server and its clients getting out of sync on the
 * logic of state transitions.
 */
