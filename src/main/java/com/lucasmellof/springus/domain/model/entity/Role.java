package com.lucasmellof.springus.domain.model.entity;

import com.lucasmellof.springus.domain.model.base.IdEntity;
import com.lucasmellof.springus.domain.model.enums.Roles;

import javax.persistence.*;

/*
 * @author Lucasmellof, Lucas de Mello Freitas created on 10/08/2022
 */

@Entity
@Table(name = "roles")
public class Role extends IdEntity {
	@Enumerated(EnumType.STRING)
	@Column(name = "role_name", length = 25)
	private Roles name;

	public Role() {
	}

	public Role(Roles role) {
		this.name = role;
	}

	public Roles getRole() {
		return name;
	}

	public void setRole(Roles role) {
		this.name = role;
	}


}
