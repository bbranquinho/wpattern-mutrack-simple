package org.wpattern.mutrack.simple.packagee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wpattern.mutrack.simple.user.UserEntity;

public interface PackageeRepository extends JpaRepository<PackageeEntity, Long> {

	public List<PackageeEntity> findByUser(UserEntity user);

}
