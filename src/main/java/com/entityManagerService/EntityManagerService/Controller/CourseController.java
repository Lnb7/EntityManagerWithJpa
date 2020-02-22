package com.entityManagerService.EntityManagerService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entityManagerService.EntityManagerService.Entity.Course;
import com.entityManagerService.EntityManagerService.Repository.CourseRepository;

@RestController
public class CourseController {

	@Autowired
	CourseRepository repo;
	
	@GetMapping("/course")
	public List<Course> findAll(){
		return repo.findAll();
	}
	
	@GetMapping("/course/{id}")
	public Course findById(@PathVariable(value = "id")Long id) {
		return repo.findById(id);
	}
	
	@PostMapping("/course")
	public Course save(@RequestBody Course course) {
		return repo.save(course);
	}
	
	
	@DeleteMapping("/course/{id}")
	public ResponseEntity<Course> deleteById(@PathVariable(value = "id")Long id){
		
		Course findCourse = findById(id);
		
		if(findCourse == null) {
			return ResponseEntity.notFound().build();
		}
		
		
		repo.deleteById(findCourse.getId());
		return ResponseEntity.ok().build();
		
	}
}
