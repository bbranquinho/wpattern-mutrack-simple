package org.wpattern.mutrack.simple.permission;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wpattern.mutrack.simple.utils.GenericService;

@RestController
@RequestMapping(path = "/permission")
public class PermissionService extends GenericService<PermissionEntity, Long> {

}
