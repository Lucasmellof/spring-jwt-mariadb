package com.lucasmellof.springus.security.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lucasmellof.springus.domain.model.entity.Person;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

/*
 * @author Lucasmellof, Lucas de Mello Freitas created on 10/08/2022
 */
public class UserDetailsImpl implements UserDetails {

	private int id;
	private String username;
	private String email;
	@JsonIgnore
	private String password;
	private Collection<? extends GrantedAuthority> authorities;


	public UserDetailsImpl(int id, String username, String email, String password, Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}

	public static UserDetailsImpl build(Person person) {
		List<SimpleGrantedAuthority> authorityList = person.getRole().stream().map(it -> new SimpleGrantedAuthority(it.getRole().name())).toList();
		return new UserDetailsImpl(person.getId(), person.getUsername(), person.getEmail(), person.getPassword(), authorityList);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		UserDetailsImpl that = (UserDetailsImpl) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (username != null ? username.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		result = 31 * result + (password != null ? password.hashCode() : 0);
		result = 31 * result + (authorities != null ? authorities.hashCode() : 0);
		return result;
	}
}
