package org.jsp.cda.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.StudentDao;
import org.jsp.cda.entity.Student;
import org.jsp.cda.exceptionClasses.InvalidStudentIdException;
import org.jsp.cda.exceptionClasses.NoStudentFoundException;
import org.jsp.cda.service.StudentService;
import org.jsp.emp.ResponseStructure.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.Setter;

@Service
public class StudentServiceImpImpl implements StudentService
{
	@Autowired
	private StudentDao studentDao;

	@Override
	public ResponseEntity<?> saveStudent(Student student) 
	{
     	return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Student Details Saved Successfully...!").body(studentDao.saveStudent(student)).build());
    }

	@Override
	public ResponseEntity<?> updateStudent(Student student) 
	{
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Studentt Details Updated Successfully............").body(studentDao.updateStudent(student)).build());
	}

	@Override
	public ResponseEntity<?> findAllStudents() 
	{
		List<Student> event = studentDao.findAllStudents();
		if(event.isEmpty())
			throw NoStudentFoundException.builder().message("No Student Found in the Database..!").build();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("All Students Found Successfully...!").body(studentDao.findAllStudents()).build());
	}

	@Override
	public ResponseEntity<?> findStudentById(int id) 
	{
		Optional<Student> optional = studentDao.findStudentById(id);
		if (optional.isEmpty()) {
			throw InvalidStudentIdException.builder().message("Invalid Student Id...,Unable to find..!").build();
		}
		Student student = optional.get();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Student Id verifies Successfully............").body(student).build());
	}

}
