package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.sql.RowSet;

import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;

public class JdbcDepartmentDao implements DepartmentDao {
	
	private final JdbcTemplate jdbcTemplate;

	public JdbcDepartmentDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Department getDepartment(Integer departmentId) {
		return null;
	}

	@Override
	public Department getDepartment(int id) {
		Department departments = null;
		String sql =
				"SELECT department_id, name " +
						"FROM department  " +
						"WHERE department_id = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
		while(results.next()) {
			 departments = mapRowToDepartment(results);
		}
		return departments;
	}

	@Override
	public List<Department> getAllDepartments() {
		List<Department>departments = new ArrayList<>();
		String sql =
				"SELECT department_id, name " +
						"FROM department;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()){
			departments.add(mapRowToDepartment(results));
		}
		return departments;
	}

	@Override
	public void updateDepartment(Department updatedDepartment) {
		String sql =
				"UPDATE department "+
				"SET name = ? "+
				"WHERE department_id = ?;";
		jdbcTemplate.update(sql, updatedDepartment.getName(), updatedDepartment.getId());

	}

	private Department mapRowToDepartment(SqlRowSet results){
		Department departments = new Department();
		departments.setId(results.getInt("department_id"));
		departments.setName(results.getString("name"));

		return departments;
	}

}
