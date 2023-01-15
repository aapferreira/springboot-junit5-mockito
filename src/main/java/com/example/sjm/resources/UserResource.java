package com.example.sjm.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.sjm.domain.User;
import com.example.sjm.domain.dto.UserDTO;
import com.example.sjm.service.UserService;

@RequestMapping(value = "/user")
@RestController
public class UserResource {
	
	private static final String ID = "/{id}";

	//O código abaixo só foi possível por ter sido criado o Bean
	//com.example.sjm.config.ModelMapperConfig;
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private UserService userService;
	
	@GetMapping(ID)
	public ResponseEntity<UserDTO> findById(@PathVariable int id) {
		return ResponseEntity.ok().body(mapper.map(userService.findById(id), UserDTO.class));
	}

	@GetMapping()
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> listaUser = userService.findAll();
		List<UserDTO> listaDTO = listaUser.stream().map(u -> mapper.map(u, UserDTO.class)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}
	
	@PostMapping
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
		User userSalvo = userService.create(userDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userSalvo.getId()).toUri();
		return ResponseEntity.created(uri).build();		
	}

	@PutMapping(ID)
	public ResponseEntity<UserDTO> updateUser(@PathVariable int id, @RequestBody UserDTO userDTO) {
		userDTO.setId(id);
		User userSalvo = userService.update(userDTO);
		return ResponseEntity.ok().body(mapper.map(userSalvo, UserDTO.class));
	}

	@DeleteMapping(ID)
	public ResponseEntity<UserDTO> updateUser(@PathVariable int id) {
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
