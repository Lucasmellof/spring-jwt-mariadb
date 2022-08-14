package com.lucasmellof.springus.domain.model;

/*
 * @author Lucasmellof, Lucas de Mello Freitas created on 10/08/2022
 */
public class JWTCredentials {
	private String jwtToken;

	public JWTCredentials() {
	}

	public JWTCredentials(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	@Override
	public String toString() {
		return "JWTCredentials{" +
				       "jwtToken='" + jwtToken + '\'' +
				       '}';
	}
}
