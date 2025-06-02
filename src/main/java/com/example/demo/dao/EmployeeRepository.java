package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.beans.EmployeeDetails;

@Repository
public class EmployeeRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<EmployeeDetails> findAll(){
		String sql = "SELECT * FROM employee_details";
		return jdbcTemplate.query(sql, (rs, rowNum) -> mapRow(rs));
	}
	
	private EmployeeDetails mapRow(ResultSet rs) throws SQLException {
		EmployeeDetails e = new EmployeeDetails();

		e.setEmployeeId(rs.getInt("employee_id"));
		e.setFullName(rs.getString("full_name"));
		e.setEmail(rs.getString("email"));
		e.setSalary(rs.getDouble("salary"));
		e.setActive(rs.getBoolean("is_active"));
		e.setJoiningDate(rs.getDate("joining_date"));
		e.setCreatedTs(rs.getTimestamp("created_ts"));
		
		return e;
	}
	
}
