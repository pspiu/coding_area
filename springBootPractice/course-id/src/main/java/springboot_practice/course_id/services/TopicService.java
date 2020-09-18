package springboot_practice.course_id.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import springboot_practice.course_id.utility.Topic;

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

	private ArrayList<Topic> topics = new ArrayList<>(
			Arrays.asList(new Topic("spring", "Spring Framework", "Description"),
					new Topic("java8", "Java 8", "Description"), new Topic("maven", "Maven", "Description")));

	public List<Topic> getAllTopics() {
		return topics;
	}

	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(String id, Topic topic) {
		for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if (t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}
	public void removeTopic(String id) {
		topics.removeIf(t->t.getId().equals(id));
	}

}
