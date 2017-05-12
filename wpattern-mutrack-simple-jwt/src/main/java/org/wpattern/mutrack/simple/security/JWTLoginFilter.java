package org.wpattern.mutrack.simple.security;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.wpattern.mutrack.simple.utils.ApplicationProperty;
import org.wpattern.mutrack.simple.utils.ServicePath;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {
    
    private ApplicationProperty applicationProperties;

    public JWTLoginFilter(AuthenticationManager authenticationManager, ApplicationProperty applicationProperties) {
        super(new AntPathRequestMatcher(ServicePath.LOGIN_PATH));
        setAuthenticationManager(authenticationManager);
        this.applicationProperties = applicationProperties;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException, IOException, ServletException {
    	AccountCredentialBean creds = new ObjectMapper().readValue(req.getInputStream(), AccountCredentialBean.class);

        return getAuthenticationManager()
        		.authenticate(new UsernamePasswordAuthenticationToken(creds.getUsername(), creds.getPassword(), Collections.emptyList()));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
            Authentication auth) throws IOException, ServletException {
    	String JWT = Jwts.builder()
                .setSubject(auth.getName())
                .setExpiration(new Date(System.currentTimeMillis() + applicationProperties.getExpirationTime()))
                .signWith(SignatureAlgorithm.HS512, applicationProperties.getJwtSecret()).compact();

        res.addHeader(ApplicationProperty.HEADER_STRING, ApplicationProperty.TOKEN_PREFIX + " " + JWT);
    }

}
