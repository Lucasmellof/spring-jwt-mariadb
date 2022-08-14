package com.lucasmellof.springus.security.services;

import com.lucasmellof.springus.domain.model.entity.Person;
import com.lucasmellof.springus.repositories.PersonRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/*
 * @author Lucasmellof, Lucas de Mello Freitas created on 10/08/2022
 */
@Component
public class UserService implements UserDetailsService {

	private final PersonRepository repository;

	public UserService(PersonRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Person person = repository.findByUsername(username)
				                        .orElseThrow(
												() -> new UsernameNotFoundException("User could not be found using username=" + username));


		Person person1 = person;
		return UserDetailsImpl.build(person1);
	}
}
