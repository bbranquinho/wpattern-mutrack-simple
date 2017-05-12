package org.wpattern.mutrack.simple.security;

import static java.util.Collections.emptyList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import org.wpattern.mutrack.simple.utils.ApplicationProperty;

import io.jsonwebtoken.Jwts;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class JWTAuthenticationFilter extends GenericFilterBean {

	 private static final String TOKEN_PREFIX = "Bearer";

    private static final String HEADER_STRING = "Authorization";
	
	@Autowired
    private ApplicationProperty applicationProperties;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		String token = ((HttpServletRequest) request).getHeader(HEADER_STRING);

		if (token != null) {
			String user = Jwts.parser().setSigningKey(applicationProperties.getJwtSecret())
					.parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody().getSubject();

			Authentication authentication = null;
			
			if (user != null) {
				authentication = new UsernamePasswordAuthenticationToken(user, null, emptyList());
			}
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		
		filterChain.doFilter(request, response);
	}

}
