package com.realscores.service.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realscores.dao.course.ICourseDao;
import com.realscores.dao.hole.IHoleDao;
import com.realscores.obj.Course;

@Service
public class CourseService implements ICourseService {

	@Autowired 
	ICourseDao courseDao;
	
	@Autowired
	IHoleDao holeDao;
	
	@Override
	public List<Course> getAllCourses() {
		return courseDao.getAllCourses();
	}

	@Override
	public Course getCourseById(int courseId) {
		Course course = courseDao.getCourseById(courseId);
		//course.setHoles(holeDao.getHoleByCourseId(courseId));
		return course;
	}

	@Override
	public boolean addCourse(Course course) {
		if (courseDao.CourseExists(course.getName())){
			return false;
		} else {
			courseDao.addCourse(course);
		    return true;
		}
	}

	@Override
	public void updateCourse(Course course) {
		courseDao.updateCourse(course);
	}

	@Override
	public void deleteCourse(int courseId) {
		courseDao.deleteCourse(courseId);
	}

}
