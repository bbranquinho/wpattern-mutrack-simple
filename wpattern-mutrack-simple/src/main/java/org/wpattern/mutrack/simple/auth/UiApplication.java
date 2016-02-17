//package org.wpattern.mutrack.simple.auth;
//
//import org.springframework.boot.autoconfigure.security.SecurityProperties;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class UiApplication {
//
//	@Configuration
//	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
//	protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//		@Override
//		protected void configure(HttpSecurity http) throws Exception {
//			http
//			.httpBasic()
//			.and()
//			.authorizeRequests()
//			.antMatchers("/index.html", "/home.html", "/login.html", "/").permitAll()
//			.anyRequest().authenticated();
//		}
//	}
//
//}
