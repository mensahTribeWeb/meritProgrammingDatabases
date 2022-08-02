package com.techelevator.projects.dao;

import com.techelevator.projects.model.Department;

import java.util.List;

public interface DepartmentDao {




	/**
	 * helper method or service class
	 * Get a department from the datastore that belongs to the given id.
	 * If the id is not found, return null.
	 *
	 * @param departmentId the department id to get from the datastore
	 * @return a filled out department object
	 */
	public Department getDepartment(Integer departmentId);

	Department getDepartment(int id);

	/**
	 * Get all departments from the datastore.
	 *
	 * @return all departments as Department objects in a List
	 */
	public List<Department> getAllDepartments();

	/**
	 * Update a department to the datastore. Only called on departments that
	 * are already in the datastore.
	 *
	 * @param updatedDepartment the department object to update
	 */
	public void updateDepartment(Department updatedDepartment);

}
