package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Locale;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcEmployeeDao implements EmployeeDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcEmployeeDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		String sql =
				"SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date " +
				"FROM employee";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()){
		employees.add(mapRowToEmployees(results));
		}
		return employees;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		List<Employee> employees = new ArrayList<>();
		String sql =
				"SELECT first_name, last_name, employee_id, department_id, birth_date, hire_date " +
						"FROM employee " +
				"WHERE first_name ILIKE '%" +firstNameSearch+ "%' AND last_name ILIKE '%"+lastNameSearch+"%';";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()){
			employees.add(mapRowToEmployees(results));
		}
		return employees;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(int projectId) {
		List<Employee> employees = new ArrayList<>();
		String sql =
				"SELECT emp.employee_id, department_id, first_name, last_name, birth_date, hire_date " +
						"FROM employee AS emp " +
						"JOIN project_employee AS pe USING (employee_id) " +
						"WHERE pe.project_id = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);
		while(results.next()){
			employees.add(mapRowToEmployees(results));
		}
		return employees;
	}

	@Override
	public void addEmployeeToProject(int projectId, int employeeId) {
		String sql =
				"INSERT INTO project_employee(project_id, employee_id)" +
				"VALUES(?, ?)";
		jdbcTemplate.update(sql, projectId, employeeId);
	}

	@Override
	public void removeEmployeeFromProject(int projectId, int employeeId) {
		String sql =
				"DELETE FROM project_employee " +
				"WHERE project_id = ? AND employee_id = ?;";
		jdbcTemplate.update(sql, projectId, employeeId);
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		List<Employee> employees = new ArrayList<>();
		String sql =
				"SELECT emp.employee_id, department_id, first_name, last_name, birth_date, hire_date "+
				"FROM employee emp "+
				"LEFT JOIN project_employee USING (employee_id) "+
				"WHERE project_id IS NULL; ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()){
			Employee employee = mapRowToEmployees(results);
			employees.add(employee);
		}
		return employees;
	}
	public Employee mapRowToEmployees(SqlRowSet results){
		Employee employee = new Employee();
		employee.setId(results.getInt("employee_id"));
		employee.setDepartmentId(results.getInt("department_id"));
		employee.setFirstName(results.getString("first_name"));
		employee.setLastName(results.getString("last_name"));
		Date birth_date = results.getDate("birth_date");
		if (birth_date != null){
			employee.setBirthDate(((java.sql.Date) birth_date).toLocalDate());
		}
		Date hire_date = results.getDate("hire_date");
		if (hire_date != null){
			employee.setHireDate(((java.sql.Date) hire_date).toLocalDate());
		}
		return employee;
	}


}
