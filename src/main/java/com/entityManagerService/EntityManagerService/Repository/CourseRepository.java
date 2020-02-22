package com.entityManagerService.EntityManagerService.Repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entityManagerService.EntityManagerService.Entity.Course;

@Repository
@Transactional
public class CourseRepository {

	@Autowired
	EntityManager em;
	
	public List<Course> findAll(){
		return em.createQuery("from Course", Course.class).getResultList();
	}
	
	public Course findById(Long id) {
		return em.find(Course.class, id);
	}
	
	public Course save(Course course) {
		if(course.getId() == null) {
			em.persist(course);
		}
		else {
			em.merge(course);
		}
		return course;
	}
	

	public void deleteById(Long id) {
		//Course course = findById(id);
		Course course = em.find(Course.class, id); 
		
		//em.getTransaction().begin();
		
		em.remove(course);
		
		//em.getTransaction().commit();
		//em.close();
		
	}
}
