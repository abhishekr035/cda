package org.jsp.cda.controller;

import org.jsp.cda.entity.Student;
import org.jsp.cda.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping(value = "/students")
public class StudentController 
{
	@Autowired
	private StudentService studentService;
	
	
	@PostMapping
	public ResponseEntity<?> saveStudent(@RequestBody Student student) 
	{
		return studentService.saveStudent(student);
	} 
	
	@PutMapping
	public ResponseEntity<?> updateStudent(@RequestBody Student student) 
	{
		return studentService.updateStudent(student);
	} 
	
	@GetMapping
	public ResponseEntity<?> findAllEvents()
	{
		return studentService.findAllStudents();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findStudentById(@PathVariable int id)
	{

		return studentService.findStudentById(id);
	}

}
