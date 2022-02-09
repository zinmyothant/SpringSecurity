package com.example.demo.model;

import javax.persistence.*;

@Entity
public class login {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String user;
private String password;
private String role;
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Boolean getEnable() {
	return enable;
}
public void setEnable(Boolean enable) {
	this.enable = enable;
}
private Boolean enable;
}
