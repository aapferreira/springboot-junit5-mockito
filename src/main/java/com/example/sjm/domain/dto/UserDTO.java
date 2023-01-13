package com.example.sjm.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private Integer id;
	private String name;
	private String email;
	//a anotação abaixo omite atributo abaixo quando feita uma requisiçao get
	//problema: ela impedirá que o atributo seja setado no POST
	//@JsonIgnore
	//a anotação abaixo omite atributo abaixo quando feita uma requisiçao get
	//mas permite que seja registrado o atributo quando é feita uma requisição POST	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;

}
