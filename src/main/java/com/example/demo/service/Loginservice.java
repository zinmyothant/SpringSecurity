package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.login;
import com.example.demo.repo.loginrepo;

@Service
public class Loginservice {
@Autowired
private loginrepo repo;
	public void save(login login) {
		repo.save(login) ;
	}
}
