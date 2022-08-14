package com.lucasmellof.springus.repositories;

import com.lucasmellof.springus.domain.model.entity.Role;
import com.lucasmellof.springus.domain.model.enums.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
 * @author Lucasmellof, Lucas de Mello Freitas created on 10/08/2022
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	Optional<Role> findByName(Roles name);

}
