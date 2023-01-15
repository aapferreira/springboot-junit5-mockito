package com.example.sjm.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sjm.domain.User;
import com.example.sjm.domain.dto.UserDTO;
import com.example.sjm.repository.UserRepository;
import com.example.sjm.service.UserService;
import com.example.sjm.service.exception.DataIntegrityViolationException;
import com.example.sjm.service.exception.ObjectNotFoundException;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public User findById(Integer id) {
		Optional<User> optUser = userRepository.findById(id);
		return optUser.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User create(UserDTO userDTO) {
		findByEmail(userDTO);
		return userRepository.save(mapper.map(userDTO, User.class));
	}
	
	private void findByEmail(UserDTO userDTO) {
		Optional<User> user = userRepository.findByEmail(userDTO.getEmail());
		if (user.isPresent() && !user.get().getId().equals(userDTO.getId())) {
			throw new DataIntegrityViolationException("E-mail já cadastrado no sistema");
		}
	}
	
	@Override
	public User update(UserDTO userDTO) {
		findByEmail(userDTO);
		return userRepository.save(mapper.map(userDTO, User.class));
	}

	@Override
	public void delete(int id) {
		User user = findById(id);
		userRepository.delete(user);
	}

}
