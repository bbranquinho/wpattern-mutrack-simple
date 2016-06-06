package org.wpattern.mutrack.simple.auth;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.wpattern.mutrack.simple.utils.BaseBean;

public class LoginDetailBean extends BaseBean implements UserDetails {

	private static final long serialVersionUID = 1L;

	private final String name;

	private final String email;

	private final String password;

	private final Set<String> roles;

	public LoginDetailBean(String name, String email, String passwordHash) {
		this.name = name;
		this.email = email;
		this.password = passwordHash;
		this.roles = new HashSet<String>();
	}

	public Set<String> getRoles() {
		return this.roles;
	}

	public void addRole(String role) {
		this.roles.add(role);
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<String> roles = this.getRoles();

		if (roles == null) {
			return Collections.emptyList();
		}

		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}

		return authorities;
	}

	@Override
	public String getUsername() {
		return this.name;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
