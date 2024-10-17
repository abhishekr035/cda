package org.jsp.cda.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.entity.Department;

public interface DepartmentDao 
{
	Department saveDepartment(Department department);

	List<Department> findAllDepartments();

	Optional<Department> findDepartmentById(int id);

//	void deleteDepartmentById(int id);

}
