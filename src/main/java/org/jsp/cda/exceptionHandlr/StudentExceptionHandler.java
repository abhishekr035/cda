package org.jsp.cda.exceptionHandlr;

import org.jsp.cda.exceptionClasses.InvalidStudentIdException;
import org.jsp.cda.exceptionClasses.NoStudentFoundException;
import org.jsp.cda.responseStructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentExceptionHandler 
{
	@ExceptionHandler(NoStudentFoundException.class)
	public ResponseEntity<?> noStudentFoundExceptionHandler(NoStudentFoundException e)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value()).message("No Student Found").body(e.getMessage()).build());
	}
	
	@ExceptionHandler(InvalidStudentIdException.class)
	public ResponseEntity<?> invalidStudentIdExceptionHandler(InvalidStudentIdException e)
	{
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseStructure.builder().status(HttpStatus.BAD_REQUEST.value()).message("Invalid Student Id").body(e.getMessage()).build());
	}

}
