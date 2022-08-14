package com.lucasmellof.springus.security.jwt;

import com.lucasmellof.springus.constants.SecurityConstants;
import com.lucasmellof.springus.security.services.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * @author Lucasmellof, Lucas de Mello Freitas created on 10/08/2022
 */
@Component
public class AuthTokenFilter extends OncePerRequestFilter {

	private final UserService userService;
	private final JWTUtil jwtUtil;

	public AuthTokenFilter(UserService userService, JWTUtil jwtUtil) {
		this.userService = userService;
		this.jwtUtil = jwtUtil;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		String header = request.getHeader(SecurityConstants.HEADER);

		if (header != null && !header.isBlank() && header.startsWith(SecurityConstants.HEADER_VALUE)) {

			String token = header.substring(SecurityConstants.HEADER_VALUE.length());

			if (token.isBlank()) {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid JWT token.");
				return;
			}

			String username = jwtUtil.validade(token);
			UserDetails userDetails = userService.loadUserByUsername(username);

			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
			authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			if (SecurityContextHolder.getContext().getAuthentication() == null) {
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}
		filterChain.doFilter(request, response);
	}

}
