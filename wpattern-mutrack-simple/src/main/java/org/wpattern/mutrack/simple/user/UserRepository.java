<<<<<<< HEAD
package org.wpattern.mutrack.simple.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	public List<UserEntity> findByEmailOrName(String email, String name);

}
=======
package org.wpattern.mutrack.simple.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	public UserEntity findByEmail(String email);
	
}
>>>>>>> 72c25ab37f178d67df6f8d065114f341db433030
