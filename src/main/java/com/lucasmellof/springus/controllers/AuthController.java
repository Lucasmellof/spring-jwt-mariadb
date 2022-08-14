package com.lucasmellof.springus.controllers;

import com.lucasmellof.springus.domain.model.JWTCredentials;
import com.lucasmellof.springus.domain.model.LoginCredentials;
import com.lucasmellof.springus.domain.model.RegisterCredentials;
import com.lucasmellof.springus.domain.model.entity.Person;
import com.lucasmellof.springus.domain.model.entity.Role;
import com.lucasmellof.springus.domain.model.enums.Roles;
import com.lucasmellof.springus.exceptions.InvalidLoginException;
import com.lucasmellof.springus.repositories.PersonRepository;
import com.lucasmellof.springus.repositories.RoleRepository;
import com.lucasmellof.springus.security.jwt.JWTUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

/*
 * @author Lucasmellof, Lucas de Mello Freitas created on 10/08/2022
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private PersonRepository personRepository;
	private RoleRepository roleRepository;
	private JWTUtil jwtUtil;
	private AuthenticationManager authenticationManager;
	private PasswordEncoder passwordEncoder;

	public AuthController(PersonRepository personRepository, RoleRepository roleRepository, JWTUtil jwtUtil, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder) {
		this.personRepository = personRepository;
		this.roleRepository = roleRepository;
		this.jwtUtil = jwtUtil;
		this.authenticationManager = authenticationManager;
		this.passwordEncoder = passwordEncoder;
	}

	@PostMapping("/register")
	public JWTCredentials postRegister(@RequestBody RegisterCredentials registerCredentials) {
		String password = passwordEncoder.encode(registerCredentials.getPassword());
		Person person = new Person(registerCredentials.getUsername(), password, registerCredentials.getEmail());

		Set<String> requestRoles = registerCredentials.getRoles();
		Set<Role> roles = new HashSet<>();
		for (String requestRole : requestRoles) {
			Roles tempRole;
			try {
				tempRole = Roles.valueOf(requestRole.toUpperCase());
			} catch (IllegalArgumentException e) {
				continue;
			}
			Role role = roleRepository.findByName(tempRole).orElseThrow(() -> new RuntimeException("Could not get role"));
			roles.add(role);
		}
		person.setRole(roles);

		personRepository.save(person);

		String token = jwtUtil.generateToken(registerCredentials.getUsername());
		return new JWTCredentials(token);
	}

	@PostMapping("/login")
	public JWTCredentials postLogin(@RequestBody LoginCredentials login) {

		try {
			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword());
			authenticationManager.authenticate(authToken);

			String token = jwtUtil.generateToken(login.getUsername());
			return new JWTCredentials(token);
		} catch (AuthenticationException exception) {
			throw new InvalidLoginException("Invalid credentials", exception);
		}
	}
}
