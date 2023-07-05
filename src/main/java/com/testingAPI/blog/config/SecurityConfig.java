package com.testingAPI.blog.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.testingAPI.blog.Security.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig{
	@Autowired
	private CustomUserDetailsService customeUserDetailsService;
	
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.csrf().disable().authorizeHttpRequests().anyRequest().authenticated().and().httpBasic();
		
		return null;
    }
     
	@Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2)
            .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
            .build();
    }
	
	@Bean
    public UserDetailsManager users(DataSource dataSource) {
		
		JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
		users.
		return null;
		
	}
	
	

}
