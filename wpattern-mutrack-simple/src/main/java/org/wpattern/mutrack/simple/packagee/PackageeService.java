package org.wpattern.mutrack.simple.packagee;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wpattern.mutrack.simple.utils.GenericService;
import org.wpattern.mutrack.simple.utils.ServiceNames;

@RestController
@RequestMapping(path = ServiceNames.PACKAGEE_PATH)
public class PackageeService extends GenericService<PackageeEntity, Long> {

	@Override
	public PackageeEntity insert(@RequestBody PackageeEntity packagee) {
		packagee.setRegisterDate(new Date());

		return super.insert(packagee);
	}

	@Override
	public void update(PackageeEntity packagee) {
		packagee.setRegisterDate(new Date());

		super.update(packagee);
	}

}
