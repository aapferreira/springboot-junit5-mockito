package com.example.sjm.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.Getter;
import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;

//@Getter
//@Setter
//@EqualsAndHashCode
//@ToString
@Entity(name = "tb_user") // 'User' é uma palavra reservada do H2 e não pode ser usado como nome da tabela
@Data // substituindo as anotações anteriores
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "O nome é obrigatório")
	@Length(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
	private String name;
	
	@NotEmpty(message = "O email é obrigatório")
	@Length(min = 3, max = 100, message = "O email deve ter entre 3 e 100 caracteres")
	@Column(unique = true)
	private String email;
	
	@NotEmpty(message = "A senha é obrigatória")
	//@Length(min = 6, max = 15, message = "A senha deve ter entre 6 e 15 caracteres")
	private String password;

}
