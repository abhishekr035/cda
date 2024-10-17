package org.jsp.cda.serviceImpl;

import java.util.Optional;

import org.jsp.cda.dao.DepartmentDao;
import org.jsp.cda.entity.Department;
import org.jsp.cda.responseStructure.ResponseStructure;
import org.jsp.cda.service.DepartmentService;
import org.jsp.emp.ExceptionClasses.InvalidCredentialException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeparmentServiceImpl implements DepartmentService
{
	@Autowired
	private DepartmentDao departmentDao;

	@Override
	public ResponseEntity<?> saveDepartment(Department department) {
		department = departmentDao.saveDepartment(department);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Department Saved Successfully...").body(department).build());
	}

	@Override
	public ResponseEntity<?> findAllDepartments() {
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("All Departments Fetched Successfully...").body(departmentDao.findAllDepartments()).build());
	}

	@Override
	public ResponseEntity<?> findDepartmentById(int id) {
		Optional<Department> optional = departmentDao.findDepartmentById(id);
		if (optional.isEmpty())
			throw InvalidCredentialException.builder().message("Invalid Department Id, Unable to find..!").build();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Department Found Successfully...").body(optional.get()).build());
	}


}
