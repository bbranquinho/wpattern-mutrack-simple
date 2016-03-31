//package org.wpattern.mutrack.simple.auth;
//
//import java.io.IOException;
//import java.security.Principal;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.SecurityProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.csrf.CsrfFilter;
//import org.springframework.security.web.csrf.CsrfToken;
//import org.springframework.security.web.csrf.CsrfTokenRepository;
//import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.filter.OncePerRequestFilter;
//import org.springframework.web.util.WebUtils;
//import org.wpattern.mutrack.simple.utils.ServiceNames;
//
//@RestController
//public class AuthApplication {
//
//	@RequestMapping(ServiceNames.AUTH_PATH)
//	public Principal user(Principal user) {
//		return user;
//	}
//
//	@Configuration
//	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
//	protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//		@Autowired
//		private UserDetailsService userDetailsService;
//
//		@Bean
//		public PasswordEncoder encoder() {
//			return new BCryptPasswordEncoder();
//		}
//
//		@Override
//		protected void configure(HttpSecurity http) throws Exception {
//			http.httpBasic()
//			.and().authorizeRequests()
//			// Public Authorities (permit all).
//			.antMatchers(ServiceNames.PUBLIC_ROOT_PATH + ServiceNames.ALL).permitAll()
//			// Package Authorities.
//			.antMatchers(ServiceNames.PRIVATE_ROOT_PATH + ServiceNames.ALL).hasAnyAuthority("ROLE_ADMIN")
//			.and().logout().logoutRequestMatcher(new AntPathRequestMatcher(ServiceNames.PUBLIC_ROOT_PATH + "/logout"))
//			.and().csrf().csrfTokenRepository(csrfTokenRepository())
//			.and().addFilterAfter(csrfHeaderFilter(), CsrfFilter.class);
//		}
//
//		@Override
//		public void configure(AuthenticationManagerBuilder auth) throws Exception {
//			auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
//		}
//
//		private Filter csrfHeaderFilter() {
//			return new OncePerRequestFilter() {
//				@Override
//				protected void doFilterInternal(final HttpServletRequest request, HttpServletResponse response,
//						FilterChain filterChain) throws ServletException, IOException {
//					CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
//
//					if (csrf != null) {
//						Cookie cookie = WebUtils.getCookie(request, "XSRF-TOKEN");
//						String token = csrf.getToken();
//
//						if (cookie == null || token != null && !token.equals(cookie.getValue())) {
//							cookie = new Cookie("XSRF-TOKEN", token);
//							cookie.setPath("/");
//							response.addCookie(cookie);
//						}
//					}
//
//					filterChain.doFilter(request, response);
//				}
//			};
//		}
//
//		private CsrfTokenRepository csrfTokenRepository() {
//			HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
//
//			repository.setHeaderName("X-XSRF-TOKEN");
//
//			return repository;
//		}
//	}
//
//}
