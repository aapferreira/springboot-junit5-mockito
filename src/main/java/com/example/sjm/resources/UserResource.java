package com.example.sjm.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sjm.domain.User;
import com.example.sjm.domain.dto.UserDTO;
import com.example.sjm.service.UserService;

@RequestMapping(value = "/user")
@RestController
public class UserResource {
	
	//O código abaixo só foi possível por ter sido criado o Bean
	//com.example.sjm.config.ModelMapperConfig;
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable int id) {
		return ResponseEntity.ok().body(mapper.map(userService.findById(id), UserDTO.class));
	}

	@GetMapping()
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> listaUser = userService.findAll();
		List<UserDTO> listaDTO = listaUser.stream().map(u -> mapper.map(u, UserDTO.class)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}

}
