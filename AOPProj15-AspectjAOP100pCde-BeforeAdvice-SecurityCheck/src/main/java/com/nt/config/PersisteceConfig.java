package com.nt.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
public class PersisteceConfig {
	
	@Bean(name="hkDs")
	public DataSource createDs() {
		HikariDataSource hkDs=null;
		hkDs=new HikariDataSource();
		hkDs.setDriverClassName("com.mysql.cj.jdbc.Driver");
		hkDs.setJdbcUrl("jdbc:mysql://localhost:3306/612");
		hkDs.setUsername("root");
		hkDs.setPassword("password");
		hkDs.setMinimumIdle(10);
		hkDs.setMaximumPoolSize(100);
		return hkDs;
	}
	
	@Bean(name="jt")
	public JdbcTemplate createJT() {
		return new JdbcTemplate(createDs());
	}

}
