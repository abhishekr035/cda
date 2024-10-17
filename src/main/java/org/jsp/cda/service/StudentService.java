package org.jsp.cda.service;

import org.jsp.cda.entity.Student;
import org.springframework.http.ResponseEntity;

public interface StudentService 
{

	ResponseEntity<?> saveStudent(Student student);

	ResponseEntity<?> updateStudent(Student student);

    ResponseEntity<?> findAllStudents();

	ResponseEntity<?> findStudentById(int id);

}
