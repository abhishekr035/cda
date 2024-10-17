package org.jsp.cda.daoImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.entity.Course;
import org.jsp.cda.repository.CourseRepository;
import org.jsp.cda.dao.CourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CourseDaoImpl implements CourseDao
{
	@Autowired
	private CourseRepository repository;

	@Override
	public Course saveCourse(Course course) {
		return repository.save(course);
	}

	@Override
	public List<Course> findAllCourses() {
		return repository.findAll();
	}

	@Override
	public Optional<Course> findCourseById(int id) {
		return repository.findById(id);
	}

}
