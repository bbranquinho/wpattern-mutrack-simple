package org.wpattern.mutrack.simple.permission;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wpattern.mutrack.simple.utils.GenericService;
import org.wpattern.mutrack.simple.utils.ServicePath;

@RestController
@RequestMapping(path = ServicePath.PERMISSION_PATH)
public class PermissionService extends GenericService<PermissionEntity, Long> {

	@Override
	public List<PermissionEntity> findAll() {
		return super.findAll();
	}

}
