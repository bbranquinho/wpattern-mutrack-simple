package org.wpattern.mutrack.simple.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.wpattern.mutrack.simple.permission.PermissionEntity;
import org.wpattern.mutrack.simple.user.UserEntity;
import org.wpattern.mutrack.simple.user.UserRepository;

@Component
public class UserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userDetails = userRepository.findByEmail(username);

		if (userDetails == null) {
			throw new UsernameNotFoundException("User with email \"" + username + "\" was not found");
		}

		Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();

		for (PermissionEntity permission : userDetails.getPermissions()) {
			authorities.add(new SimpleGrantedAuthority(permission.getRole()));
		}

		return new User(userDetails.getName(), userDetails.getPassword(), true, true, true, true, authorities);
	}

}
