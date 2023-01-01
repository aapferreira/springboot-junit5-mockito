package com.example.sjm.service;

import java.util.List;

import com.example.sjm.domain.User;

public interface UserService {
	
	User findById(Integer id);
	List<User> findAll();

}
