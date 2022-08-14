package com.lucasmellof.springus.exceptions;

import org.springframework.security.core.AuthenticationException;

/*
 * @author Lucasmellof, Lucas de Mello Freitas created on 10/08/2022
 */
public class InvalidLoginException extends AuthenticationException {
	public InvalidLoginException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public InvalidLoginException(String msg) {
		super(msg);
	}
}
