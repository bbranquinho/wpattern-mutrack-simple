package org.wpattern.mutrack.simple.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.wpattern.mutrack.simple.user.UserEntity;
import org.wpattern.mutrack.simple.user.UserRepository;
import org.wpattern.mutrack.simple.utils.ServiceMap;
import org.wpattern.mutrack.simple.utils.ServiceNames;

@RestController
@RequestMapping(path = ServiceNames.AUTH_PATH)
public class AuthenticationService implements ServiceMap {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(method = { RequestMethod.POST })
	public UserEntity authenticate(@RequestBody AuthenticationBean authentication) {
		return userRepository.findByEmail(authentication.getEmail());
	}

}
