package com.app.ecommerce.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.app.ecommerce.jwt_utils.JwtUtils;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	// auto wire jwt utils
	@Autowired
	private JwtUtils jwtUtils;

	// auto wire dao based user details service
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			System.out.println("In filter ");
			String authHeader = request.getHeader("Authorization");
			if (authHeader != null && authHeader.startsWith("Bearer ")) {
				System.out.println("contains JWT " + authHeader);
				String jwt = authHeader.substring(7);// extracting jwt token value from auth header

				if (jwtUtils.validateJwtToken(jwt)) {
					UserDetails userDetails = userDetailsService
							.loadUserByUsername(jwtUtils.getUserNameFromJwtToken(jwt));

					if (SecurityContextHolder.getContext().getAuthentication() == null) {
						UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
								userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());

						authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
						SecurityContextHolder.getContext().setAuthentication(authentication);
					}
				}
			}

		} finally {
			filterChain.doFilter(request, response);
		}
	}

}
