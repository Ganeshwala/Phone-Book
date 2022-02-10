package com.ContactApp.Configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
//@ComponentScan(basePackages = {"com.ContactApp"})
public class SpringRootConfig {

	@Bean
	public DataSource DataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb");
		dataSource.setUsername("Ganeshwc");
		dataSource.setPassword("N84e6BFr@27");
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbctemplate() {
		JdbcTemplate jTeamplate = new JdbcTemplate(DataSource());
		return jTeamplate;
	}
}
