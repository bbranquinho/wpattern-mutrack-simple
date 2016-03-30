package org.wpattern.mutrack.simple.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wpattern.mutrack.simple.utils.GenericService;
import org.wpattern.mutrack.simple.utils.ServiceNames;

@RestController
@RequestMapping(path = ServiceNames.USER_PATH)
public class UserService extends GenericService<UserEntity, Long> {

}
