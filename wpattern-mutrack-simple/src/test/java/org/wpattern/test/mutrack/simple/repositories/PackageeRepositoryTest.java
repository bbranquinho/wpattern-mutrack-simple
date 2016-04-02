package org.wpattern.test.mutrack.simple.repositories;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wpattern.mutrack.simple.packagee.PackageeEntity;
import org.wpattern.mutrack.simple.packagee.PackageeRepository;
import org.wpattern.test.mutrack.simple.utils.AppContextTest;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppContextTest.class)
public class PackageeRepositoryTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserRepositoryTest.class);

	@Autowired
	private PackageeRepository packageeRepository;

	@Test
	public void findAllTest() {
		List<PackageeEntity> packagees = this.packageeRepository.findAll();

		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("Test FindAll(): " + packagees);
		}
	}

}
