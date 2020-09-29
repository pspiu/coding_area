package springboot_practice.course_id.controllers;

import java.lang.annotation.Target;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springboot_practice.course_id.services.TopicService;
import springboot_practice.course_id.utility.Topic;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;

	/*
	 * priya: generate JSON will jave key names corresponding to property names of
	 * Topic class and values are values of those properties
	 */
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}

	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		/*
		 * priya: If path-variable provided in @RequestMapping is diff than the method
		 * arg, padd the path var name in @PathVariable
		 */
		// public Topic getTopic(@PathVariable("id") String id)
		return topicService.getTopic(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void createTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public void putTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(id, topic);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.removeTopic(id);
	}
}
