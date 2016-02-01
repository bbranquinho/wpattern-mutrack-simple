package org.wpattern.mutrack.simple.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wpattern.mutrack.simple.utils.GenericService;

@RestController
@RequestMapping(path = "/user")
public class UserService extends GenericService<UserEntity, Long> {

}
