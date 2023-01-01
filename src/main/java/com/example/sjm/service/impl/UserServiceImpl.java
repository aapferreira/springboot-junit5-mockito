package com.example.sjm.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sjm.domain.User;
import com.example.sjm.repository.UserRepository;
import com.example.sjm.service.UserService;
import com.example.sjm.service.exception.ObjectNotFoundException;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findById(Integer id) {
		Optional<User> optUser = userRepository.findById(id);
		return optUser.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

}
