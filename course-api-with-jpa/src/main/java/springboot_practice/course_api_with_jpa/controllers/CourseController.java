package springboot_practice.course_api_with_jpa.controllers;

import java.lang.annotation.Target;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springboot_practice.course_api_with_jpa.model.Course;
import springboot_practice.course_api_with_jpa.model.Topic;
import springboot_practice.course_api_with_jpa.services.CourseService;
import springboot_practice.course_api_with_jpa.services.TopicService;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	/*
	 * priya: generate JSON will jave key names corresponding to property names of
	 * Topic class and values are values of those properties
	 */
	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable String topicId) {
		return courseService.getAllCourses(topicId);
	}

	@RequestMapping("/topics/{topicId}/courses/{courseId}")
	public Optional<Course> getTopic(@PathVariable String courseId) {
		/*
		 * priya: If path-variable provided in @RequestMapping is diff than the method
		 * arg, add the path var name in @PathVariable
		 */
		// public Topic getTopic(@PathVariable(""id) String id)
		return courseService.getCourse(courseId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
	public void createCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
	public void putCourse(@RequestBody Course course, @PathVariable String id) {
		course.setTopic(new Topic(id,"",""));
		courseService.updateCourse(course);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		courseService.removeCourse(id);
	}
}
