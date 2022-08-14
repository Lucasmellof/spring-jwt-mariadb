package com.lucasmellof.springus.domain.model.base;

import javax.persistence.*;
import java.io.Serializable;

/*
 * @author Lucasmellof, Lucas de Mello Freitas created on 05/08/2022
 */
@MappedSuperclass
public class IdEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public boolean isDirty() {
		return this.id == null;
	}
}
