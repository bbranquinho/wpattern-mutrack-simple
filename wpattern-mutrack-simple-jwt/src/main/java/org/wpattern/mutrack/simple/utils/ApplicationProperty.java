package org.wpattern.mutrack.simple.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class ApplicationProperty {
	
	public static final String TOKEN_PREFIX = "Bearer";

	public static final String HEADER_STRING = "Authorization";

	@Value("${security.password.secret}")
	private String secret;
	
	@Value("${security.jwt.secret}")
	private String jwtSecret;

	@Value("${security.expirationTime}")
    private Long expirationTime;
	
	public String getJwtSecret() {
		return jwtSecret;
	}

	public void setJwtSecret(String jwtSecret) {
		this.jwtSecret = jwtSecret;
	}

	public ApplicationProperty() {
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public Long getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(Long expirationTime) {
		this.expirationTime = expirationTime;
	}

}
