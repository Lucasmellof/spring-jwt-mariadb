package com.lucasmellof.springus.domain.model;

import java.util.Set;

/*
 * @author Lucasmellof, Lucas de Mello Freitas created on 10/08/2022
 */
public class RegisterCredentials {
	private String username;
	private String password;
	private String email;
	private Set<String> roles;

	public RegisterCredentials() {
	}

	public RegisterCredentials(String username, String password, String email, Set<String> roles) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.roles = roles;
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

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
}
