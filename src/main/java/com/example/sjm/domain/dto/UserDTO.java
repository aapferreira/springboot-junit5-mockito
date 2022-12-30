package com.example.sjm.domain.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonIgnore //essa anotação omite atributo abaixo quando feita uma requisiçao get
	private String password;

}