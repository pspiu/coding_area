package springboot_practice.course_api_with_jpa.service.serviceImpl;

import org.springframework.data.repository.CrudRepository;

import springboot_practice.course_api_with_jpa.model.Topic;

public interface TopicRepository extends CrudRepository<Topic,String>{
 
}
