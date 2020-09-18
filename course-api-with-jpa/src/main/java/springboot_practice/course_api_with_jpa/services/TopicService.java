package springboot_practice.course_api_with_jpa.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot_practice.course_api_with_jpa.model.Topic;
import springboot_practice.course_api_with_jpa.service.serviceImpl.TopicRepository;

@Service
public class TopicService {

	/*
	 * priya: if we write below statement as given below i.e. Arrays.asList() w/o
	 * ArrayList then we can not update the List This is because: Arrays.asList()
	 * create immutable list
	 */
	/*
	 * private List<Topic> topics1 = Arrays.asList(new Topic("spring",
	 * "Spring Framework", "Description"), new Topic("java8", "Java 8",
	 * "Description"), new Topic("maven", "Maven", "Description"));
	 */


	@Autowired
	private TopicRepository topicRepository;

	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<Topic>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}

	public Optional<Topic> getTopic(String id) {
		return topicRepository.findById(id);
			}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
	}
	public void removeTopic(String id) {
		topicRepository.deleteById(id);
	}

}
