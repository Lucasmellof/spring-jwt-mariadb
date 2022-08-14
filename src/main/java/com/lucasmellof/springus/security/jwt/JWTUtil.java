package com.lucasmellof.springus.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.lucasmellof.springus.constants.SecurityConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/*
 * @author Lucasmellof, Lucas de Mello Freitas created on 10/08/2022
 */
@Component
public class JWTUtil {
	@Value("${springer.jwt_secret}")
	private String secret;

	@Value("${springer.jwt_expiration_time}")
	private int expirationTime;

	public String generateToken(String username) {
		System.out.println(expirationTime);
		return JWT.create()
				       .withSubject(SecurityConstants.SUBJECT)
				       .withClaim(SecurityConstants.CLAIM, username)
				       .withExpiresAt(new Date(System.currentTimeMillis() + (expirationTime * 1000L)))
				       .withIssuedAt(new Date())
				       .withIssuer(SecurityConstants.ISSUER)
				       .sign(Algorithm.HMAC512(secret));
	}

	public String validade(String token) {
		JWTVerifier verifier = JWT.require(Algorithm.HMAC512(secret))
				                       .withSubject(SecurityConstants.SUBJECT)
				                       .withIssuer(SecurityConstants.ISSUER)
				                       .build();

		DecodedJWT jwt = verifier.verify(token);

		return jwt.getClaim(SecurityConstants.CLAIM).asString();
	}
}
