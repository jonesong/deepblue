package org.deepblue.dailyroutine.springmvc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

//@Entity
//@Table(name="USERS")
@Data // All fields are private and final. Getters and setters are generated (https://projectlombok.org/features/Value.html)
public class Login implements Serializable{

	@NotEmpty @Length(max=30)
	@Column(name="USERNAME", unique=true, nullable=false)
	String username;
	
	@NotEmpty @Length(max=40)
	@Column(name="PASSWORD", nullable=false)
	String password;
	
	@NotEmpty
	@Column(name="DELETED", nullable=false)
	String deleted ="1";
}
