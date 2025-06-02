package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int deleteTableIfExists() {
		String sql = "DROP TABLE STUDENT";
		return jdbcTemplate.update(sql);
	}
	
	public int deleteTable(String table) {
		String sql = "DROP TABLE "+table;
		return jdbcTemplate.update(sql);
	}

}
