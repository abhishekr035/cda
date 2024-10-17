package org.jsp.cda.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.CourseDao;
import org.jsp.cda.entity.Course;
import org.jsp.cda.responseStructure.ResponseStructure;
import org.jsp.cda.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CourseserviceImpl implements CourseService
{
	@Autowired
	private CourseDao courseDao;
	
	
	
	@Override
	public ResponseEntity<?> saveCourse(Course course) {
		
		course = courseDao.saveCourse(course);
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Course Created Successfully...").body(course).build());
	}

	@Override
	public ResponseEntity<?> findAllCourses() {
		List<Course> courses = courseDao.findAllCourses();
		if(courses.isEmpty())
			throw new RuntimeException("No Courses Present In Database Table...");
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("All Courses Found Successfully...").body(courses).build());
	}

	@Override
	public ResponseEntity<?> findCourseById(int id) {
		Optional<Course> optional = courseDao.findCourseById(id);
		if(optional.isEmpty())
			throw new RuntimeException("Ivalid Course Id : "+id);
		Course course = optional.get();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Course Found Successfully...").body(course).build());
	}

}
