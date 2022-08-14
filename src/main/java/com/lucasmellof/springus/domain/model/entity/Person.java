package com.lucasmellof.springus.domain.model.entity;

import com.lucasmellof.springus.domain.model.base.IdEntity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/*
 * @author Lucasmellof, Lucas de Mello Freitas created on 10/08/2022
 */
@Entity
@Table(name = "user")
public class Person extends IdEntity {

	@Column(name = "username", nullable = false, unique = true)
	private String username;

	@Size(min = 6)
	@Column(name = "password", nullable = false)
	private String password;

	@Email
	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "user_roles",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	private Set<Role> role = new HashSet<>();

	public Person() {
	}

	public Person(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}
}
