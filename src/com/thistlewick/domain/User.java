package com.thistlewick.domain;
import com.thistlewick.exception.InvalidEmailException;

import jakarta.persistence.*;
@Entity
@Table(name = "users")
public class User {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String email;
	
	
	protected User() {}
	
	public User(String name, String email) throws InvalidEmailException { // validation from User Email --> like => [
																			// Example@gmail.com ] .
		boolean result = email.matches("^[a-zA-Z]+@[a-zA-Z]+\\.[a-zA-Z]+$");

		if (result) {
			this.name = name;
			this.email = email;
		} else
			throw new InvalidEmailException("Invalid email");
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

}
