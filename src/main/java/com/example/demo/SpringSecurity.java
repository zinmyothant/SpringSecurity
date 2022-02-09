package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter {
	@Autowired
	private BCryptPasswordEncoder encode;
	@Autowired
	private DataSource datasource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").hasAnyRole("Teacher", "Student").antMatchers("/teacher/**")
				.hasRole("Teacher").antMatchers("/student/**").hasAnyRole("Teacher", "Student").and().formLogin()
				.loginPage("/loginPage").defaultSuccessUrl("/").

				and().logout();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().passwordEncoder(encode).withUser("admin").password(encode.encode("admin"))
//				.roles("Teacher");
//		auth.inMemoryAuthentication().passwordEncoder(encode).withUser("student").password(encode.encode("student"))
//				.roles("Student");
		auth.jdbcAuthentication().passwordEncoder(encode).dataSource(datasource)
				.usersByUsernameQuery("select user,password,enable from login where user=?")
				.authoritiesByUsernameQuery("select user,role from login where user=?");
	}

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		BCryptPasswordEncoder en = new BCryptPasswordEncoder();
		System.out.println(en.encode("admin"));
	}
}
