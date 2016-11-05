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
@Table(name="MODULES")
@Data // All fields are private and final. Getters and setters are generated (https://projectlombok.org/features/Value.html)
public class Module implements Serializable{

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;

	@NotEmpty
	@Column(name="USER_ID", nullable=false)
	Integer user_id;

	@NotEmpty @Length(max=30)
	@Column(name="NAME", unique=true, nullable=false)
	String name;
	
	@NotEmpty
	@Column(name="DELETED", nullable=false)
	String deleted ="1";
}
