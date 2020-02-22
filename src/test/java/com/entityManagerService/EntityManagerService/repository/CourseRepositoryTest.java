package com.entityManagerService.EntityManagerService.repository;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.entityManagerService.EntityManagerService.EntityManagerServiceApplication;
import com.entityManagerService.EntityManagerService.Entity.Course;
import com.entityManagerService.EntityManagerService.Repository.CourseRepository;

@SpringBootTest(classes =  EntityManagerServiceApplication.class)
class CourseRepositoryTest {	
	@Autowired
	CourseRepository repo;
	
	@Test
	void findById_Test() {
		Course course = repo.findById(2L);
		assertEquals("Spring core - updated", course.getName());
		
	}
	
	@Test
	@DirtiesContext
	void deleteById_Test() {
		repo.deleteById(2l);
		assertNull(repo.findById(2l));
		
	}
	
	@Test
	@DirtiesContext
	void save_Test() {
		
		//get course
		Course course = repo.findById(2L);
		assertEquals("Spring core", course.getName());
		
		//update 
		course.setName("Spring core - updated");
		
		//save
		repo.save(course);
		
		//check the value 
		Course course1 = repo.findById(2L);
		assertEquals("Spring core - updated", course1.getName());
		
	}

}
