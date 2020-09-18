package springboot_practice.course_id;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseApiApp {
	public static void main(String[] args) {
		/* 
		 * priya: SpringApplication.run() : static method
		 * takes 2 args:
		 * a)Driver class name
		 * b) input arguments
		 * c) It starts Spring App Context (container)
		 * d) perform class path scan (find classes with annotations); we add marker to classes: controller, service etc.
		 * e) starts Tomcat server for us (no need to download)
		 */

		SpringApplication.run(CourseApiApp.class, args);
	}
}
