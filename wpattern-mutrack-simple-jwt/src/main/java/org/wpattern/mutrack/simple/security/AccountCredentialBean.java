package org.wpattern.mutrack.simple.security;

import org.wpattern.mutrack.simple.utils.BaseBean;

public class AccountCredentialBean extends BaseBean {

	private static final long serialVersionUID = 201705112146L;

	private String username;

	private String password;
	
	public AccountCredentialBean() {
	}

	public AccountCredentialBean(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
