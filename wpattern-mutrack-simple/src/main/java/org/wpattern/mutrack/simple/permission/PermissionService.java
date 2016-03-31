package org.wpattern.mutrack.simple.permission;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wpattern.mutrack.simple.utils.GenericService;
import org.wpattern.mutrack.simple.utils.ServiceNames;

@RestController
@RequestMapping(path = ServiceNames.PERMISSION_PATH)
public class PermissionService extends GenericService<PermissionEntity, Long> {

}
