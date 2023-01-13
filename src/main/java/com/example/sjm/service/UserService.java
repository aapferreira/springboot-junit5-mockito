package com.example.sjm.service;

import java.util.List;

import com.example.sjm.domain.User;
import com.example.sjm.domain.dto.UserDTO;

public interface UserService {
	
	User findById(Integer id);
	List<User> findAll();
	User createUser(UserDTO userDTO);

}
