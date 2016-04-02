package org.wpattern.mutrack.simple.packagee;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wpattern.mutrack.simple.user.UserRepository;
import org.wpattern.mutrack.simple.utils.GenericService;
import org.wpattern.mutrack.simple.utils.ServiceNames;

@RestController
@RequestMapping(path = ServiceNames.PACKAGEE_PATH)
public class PackageeService extends GenericService<PackageeEntity, Long> {

	@Autowired
	private UserRepository userRepository;

	@Override
	public PackageeEntity insert(@RequestBody PackageeEntity packagee) {
		packagee.setRegisterDate(new Date());
		packagee.setUser(userRepository.findOne(1L));

		return super.insert(packagee);
	}

	@Override
	public void update(PackageeEntity packagee) {
		packagee.setRegisterDate(new Date());
		packagee.setUser(userRepository.findOne(1L));

		super.update(packagee);
	}

}
