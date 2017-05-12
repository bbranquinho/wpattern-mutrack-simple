package org.wpattern.mutrack.simple.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.wpattern.mutrack.simple.utils.ApplicationProperty;
import org.wpattern.mutrack.simple.utils.ServicePath;

@EnableWebSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter {

	public static final String AUTH_USER = "ROLE_USER";

	public static final String AUTH_ADMIN = "ROLE_ADMIN";

	@Autowired
	private UserDetailsService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JWTAuthenticationFilter jwtAuthenticationFilter;
	
	@Autowired
	private ApplicationProperty applicationProperties;

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.userService).passwordEncoder(this.passwordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests()
		// Global Authority to OPTIONS (permit all).
		.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
		// Public (permit all).
		.antMatchers(ServicePath.PUBLIC_ROOT_PATH + ServicePath.ALL).permitAll()
		// Package Authorities.
		.antMatchers(HttpMethod.GET, ServicePath.PACKAGEE_PATH).hasAnyAuthority(AUTH_USER, AUTH_ADMIN)
		.antMatchers(HttpMethod.POST, ServicePath.PACKAGEE_PATH).hasAnyAuthority(AUTH_USER, AUTH_ADMIN)
		.antMatchers(HttpMethod.PUT, ServicePath.PACKAGEE_PATH).hasAnyAuthority(AUTH_USER, AUTH_ADMIN)
		.antMatchers(HttpMethod.DELETE, ServicePath.PACKAGEE_PATH).hasAnyAuthority(AUTH_USER, AUTH_ADMIN)
		// User Authorities.
		.antMatchers(HttpMethod.GET, ServicePath.USER_PATH).hasAnyAuthority(AUTH_ADMIN)
		.antMatchers(HttpMethod.POST, ServicePath.USER_PATH).hasAnyAuthority(AUTH_ADMIN)
		.antMatchers(HttpMethod.PUT, ServicePath.USER_PATH).hasAnyAuthority(AUTH_ADMIN)
		.antMatchers(HttpMethod.DELETE, ServicePath.USER_PATH).hasAnyAuthority(AUTH_ADMIN)
		// Permission Authorities.
		.antMatchers(HttpMethod.GET, ServicePath.PERMISSION_PATH).hasAnyAuthority(AUTH_ADMIN)
		.anyRequest().fullyAuthenticated().and()
		// CSRF configuration.
		.csrf().disable()
		// We filter the api/login requests.
        .addFilterBefore(new JWTLoginFilter(authenticationManager(), applicationProperties), UsernamePasswordAuthenticationFilter.class)
        // And filter other requests to check the presence of JWT in header.
        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
	}

	
}
