package springboot_practice.course_api_with_jpa.service.serviceImpl;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import springboot_practice.course_api_with_jpa.model.Course;

public interface CourseRepository extends CrudRepository<Course, String> {
	public List<Course> findByName(String name);

	
	/*
	 * Req always in camelCase
	 * format to find methods:
	 * "findBy"<property>();
	 * where property can be <class><property> eg: findByTopicId
	 */
	public List<Course> findByDescription(String name);

	/*
	 * priya:we're looking for id property of topic property
	 */
	public List<Course> findByTopicId(String topicId);
	
}