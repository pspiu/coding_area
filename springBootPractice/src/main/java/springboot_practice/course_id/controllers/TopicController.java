package springboot_practice.course_id.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot_practice.course_id.utility.Topic;

@RestController
public class TopicController {

	/*
	 * priya: generate JSON will jave key names corresponding to property names of
	 * Topic class and values are values of those properties
	 */
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return Arrays.asList(new Topic("spring", "Spring Framework", "Description"),
				new Topic("java8", "Java 8", "Description"), new Topic("maven", "Maven", "Description"));
	}
}
