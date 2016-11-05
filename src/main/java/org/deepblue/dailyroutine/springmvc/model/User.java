package org.deepblue.dailyroutine.springmvc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Entity
@Table(name="USERS")
@Data // All fields are private and final. Getters and setters are generated (https://projectlombok.org/features/Value.html)
public class User implements Serializable{

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;

	@NotEmpty @Length(max=30)
	@Column(name="USERNAME", unique=true, nullable=false)
	String username;
	
	@NotEmpty @Length(max=40)
	@Column(name="PASSWORD", nullable=false)
	String password;
		
	@NotEmpty @Length(max=30)
	@Column(name="FIRST_NAME", nullable=false)
	String first_name;

	@NotEmpty @Length(max=30)
	@Column(name="LAST_NAME", nullable=false)
	String last_name;

	@Column(name="STATUS", nullable=false)
	char status ='1';
	
	@Column(name="DELETED", nullable=false)
	char deleted ='1';

//	public User(String username, String password, String first_name, String last_name) {
//		this.username = username;
//		this.password = password;
//		this.first_name = first_name;
//		this.last_name = last_name;
//	}
//	
//	public User(){
//	}

}
