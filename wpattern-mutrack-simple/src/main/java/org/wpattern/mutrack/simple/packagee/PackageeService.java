package org.wpattern.mutrack.simple.packagee;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wpattern.mutrack.simple.auth.CurrentUser;
import org.wpattern.mutrack.simple.user.UserEntity;
import org.wpattern.mutrack.simple.user.UserRepository;
import org.wpattern.mutrack.simple.utils.GenericService;
import org.wpattern.mutrack.simple.utils.ServicePath;

@RestController
@RequestMapping(path = ServicePath.PACKAGEE_PATH)
public class PackageeService extends GenericService<PackageeEntity, Long> {

	@Autowired
	private CurrentUser currentUser;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PackageeRepository packageRepository;

	@Override
	public List<PackageeEntity> findAll() {
		UserEntity user = this.userRepository.findByEmail(currentUser.getActiveUser().getEmail());

		return this.packageRepository.findByUser(user);
	}

	@Override
	public PackageeEntity insert(@RequestBody PackageeEntity packagee) {
		setDetails(packagee);
		return super.insert(packagee);
	}

	@Override
	public void update(PackageeEntity packagee) {
		setDetails(packagee);
		super.update(packagee);
	}

	private void setDetails(PackageeEntity packagee) {
		UserEntity user = this.userRepository.findByEmail(currentUser.getActiveUser().getEmail());

		packagee.setUser(user);
		packagee.setRegisterDate(new Date());
	}

}
