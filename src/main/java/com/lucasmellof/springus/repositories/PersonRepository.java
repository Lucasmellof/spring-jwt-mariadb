package com.lucasmellof.springus.repositories;


import com.lucasmellof.springus.domain.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/*
 * @author Lucasmellof, Lucas de Mello Freitas created on 11/07/2022
 */
public interface PersonRepository extends JpaRepository<Person, Integer> {


	Optional<Person> findByUsername(String username);
	Optional<Person> findByEmail(String email);

}
