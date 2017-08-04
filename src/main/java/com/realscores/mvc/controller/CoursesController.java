package com.realscores.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.realscores.obj.Course;
import com.realscores.service.course.ICourseService;

@Controller
@RequestMapping("/courses")
public class CoursesController {
  
	@Autowired
	ICourseService courseService;
	
	@GetMapping()
	public ResponseEntity<List<Course>> getCourses(){		
		List<Course> courses = courseService.getAllCourses();
		return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Course> getCourseById(
			@PathVariable("id") int courseId){		
		Course course = courseService.getCourseById(courseId);
		return new ResponseEntity<Course>(course, HttpStatus.OK);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createCourse(@RequestBody Course course, UriComponentsBuilder builder){		
		boolean flag = courseService.addCourse(course);
		if (flag == false) {
	      return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/courses/{id}").buildAndExpand(course.getCourseId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping()
	public ResponseEntity<Course> updateCourse(@RequestBody Course course) {
		courseService.updateCourse(course);
		return new ResponseEntity<Course>(course, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCourse(@PathVariable("id") Integer id) {
		courseService.deleteCourse(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
}
