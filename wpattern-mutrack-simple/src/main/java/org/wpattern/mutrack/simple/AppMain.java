package org.wpattern.mutrack.simple;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wpattern.mutrack.simple.auth.CsrfHeaderFilter;
import org.wpattern.mutrack.simple.utils.AppContext;

@SpringBootApplication
@RestController
public class AppMain {

	public static void main(String[] args) {
		SpringApplication.run(AppContext.class, args);
	}

	@RequestMapping("/auth")
	public Principal user(Principal user) {
		return user;
	}

	@Configuration
	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
			.httpBasic().and()
			.authorizeRequests()
			.antMatchers("/index.html", "/home.html", "/login.html", "/").permitAll().anyRequest()
			.authenticated().and()
			.addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class);
		}
	}



}
