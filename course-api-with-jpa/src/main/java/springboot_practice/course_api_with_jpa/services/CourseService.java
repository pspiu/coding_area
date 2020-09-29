package springboot_practice.course_api_with_jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot_practice.course_api_with_jpa.model.Course;
import springboot_practice.course_api_with_jpa.service.serviceImpl.CourseRepository;

@Service
public class CourseService {

	/*
	 * priya: if we write below statement as given below i.e. Arrays.asList() w/o
	 * ArrayList then we can not update the List This is because: Arrays.asList()
	 * create immutable list
	 */
	/*
	 * private List<Course> course1 = Arrays.asList(new Course("spring",
	 * "Spring Framework", "Description"), new Course("java8", "Java 8",
	 * "Description"), new Course("maven", "Maven", "Description"));
	 */


	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getAllCourses(String id) {
		List<Course> course = new ArrayList<Course>();
		courseRepository.findByTopicId(id).forEach(course::add);
		return course;
	}

	public Optional<Course> getCourse(String id) {
		return courseRepository.findById(id);
			}

	public void addCourse(Course topic) {
		courseRepository.save(topic);
	}

	public void updateCourse(Course course) {
		courseRepository.save(course);
	}
	public void removeCourse(String id) {
		courseRepository.deleteById(id);
	}

}
