package springboot_practice.course_id.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * priya: default request mapping is for GET
 */
@RestController
public class HelloController {
	@RequestMapping("/hello")
	public String sayHello() {
		return "Hello";
	}

}
