package org.jsp.cda.daoImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.StudentDao;
import org.jsp.cda.entity.Student;
import org.jsp.cda.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl implements StudentDao
{
	@Autowired
	private StudentRepository studentRepository;

	
	@Override
	public Student saveStudent(Student student) 
	{
		return studentRepository.save(student);
	}

	@Override
	public Student updateStudent(Student student) 
	{
		return studentRepository.save(student);
	}

	@Override
	public Optional<Student> findStudentById(int id) 
	{
		return studentRepository.findById(id);
	}

	@Override
	public List<Student> findAllStudents() 
	{
		return studentRepository.findAll();
	}

}
