package com.lucasmellof.springus.controllers;

import com.lucasmellof.springus.repositories.PersonRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author Lucasmellof, Lucas de Mello Freitas created on 10/08/2022
 */
@RestController
@RequestMapping("/api/person")
public class PersonController {
	private PersonRepository repository;

	public PersonController(PersonRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/noperm")
	public String getNoPerm() {
		return "You do not need permission to access this page =)";
	}

	@GetMapping("/info")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public String getInfo() {
		return "You are authenticated";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String getAdminInfo() {
		return "You have admin permissions";
	}
}
