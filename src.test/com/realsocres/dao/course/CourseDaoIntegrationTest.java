package com.realsocres.dao.course;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.realscores.dao.course.ICourseDao;
import com.realscores.obj.Course;
import com.realsocres.dao.DaoTestBaseClass;

@RunWith(SpringJUnit4ClassRunner.class) 
public class CourseDaoIntegrationTest extends DaoTestBaseClass {

	@Autowired
	ICourseDao courseDao;
	
	@Test
	public void getAllCourses_happyPath(){
		List<Course> courses = courseDao.getAllCourses();
		Assert.assertEquals(6, courses.size());
	}
	
}
