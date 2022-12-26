package com.example.sjm.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sjm.domain.User;
import com.example.sjm.repository.UserRepository;
import com.example.sjm.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findById(Integer id) {
		Optional<User> optUser = userRepository.findById(id);
		return optUser.orElse(null);
	}

}
