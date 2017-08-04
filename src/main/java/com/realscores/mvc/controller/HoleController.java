package com.realscores.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.realscores.obj.Hole;
import com.realscores.service.hole.IHoleService;

@Controller
public class HoleController {
  
	@Autowired
	IHoleService holeService;
	
	@GetMapping("/courses/{courseId}/holes")
	public ResponseEntity<List<Hole>> getCourseHoles(@PathVariable("courseId") int courseId){		
		List<Hole> holes = holeService.getHolesByCourseId(courseId);
		return new ResponseEntity<List<Hole>>(holes, HttpStatus.OK);
	}
	
	@GetMapping("/courses/{courseId}/holes/{holeId}")
	public ResponseEntity<Hole> getHoleById(
			@PathVariable("courseId") int courseId,
			@PathVariable("holeId") int holeId){		
		Hole hole = holeService.getHoleByHoleId(holeId);
		return new ResponseEntity<Hole>(hole, HttpStatus.OK);
	}
}
