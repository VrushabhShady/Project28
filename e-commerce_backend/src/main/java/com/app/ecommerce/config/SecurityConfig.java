package com.app.ecommerce.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.app.ecommerce.filters.JwtRequestFilter;

@EnableWebSecurity // mandatory
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	// auto wire instance of custom user details service
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtRequestFilter jwtFilter;
	
	// configure password encoder bean: BCrypt encoder
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	// Authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// override this method to enable DAO based authentication using JPA
		auth.userDetailsService(userDetailsService);
	}

	
	// Authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
				.authorizeRequests()
				.antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/user/**").hasAnyRole("CUSTOMER", "ADMIN")
				.antMatchers("/home/**").permitAll()
				.antMatchers("/", "/signup").permitAll()
				.antMatchers("/signin").permitAll()
				.antMatchers(HttpMethod.GET, "/product").permitAll()
				//.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
				.and()			
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	}
}
