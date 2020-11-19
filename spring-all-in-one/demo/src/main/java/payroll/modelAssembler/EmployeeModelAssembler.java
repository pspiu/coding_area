package payroll.modelAssembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import payroll.controllers.EmployeeController;
import payroll.entities.Employee;

/*@Component:  this component will be automatically created when the app starts.
 * This simple interface has one method: toModel(). 
 * It is based on converting a non-model object (Employee) into a model-based object (EntityModel<Employee>).
 */
@Component
public class EmployeeModelAssembler implements RepresentationModelAssembler<Employee, EntityModel<Employee>> {

	@Override
	public EntityModel<Employee> toModel(Employee employee) {

		return EntityModel.of(employee,
				linkTo(methodOn(EmployeeController.class).one(employee.getId())).withSelfRel(),
				linkTo(methodOn(EmployeeController.class).all()).withRel("employees"));
	}
}