package org.wpattern.mutrack.simple.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	public List<UserEntity> findByEmailOrName(String email, String name);

}
