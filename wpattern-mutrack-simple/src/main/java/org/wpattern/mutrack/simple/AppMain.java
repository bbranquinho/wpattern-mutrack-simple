package org.wpattern.mutrack.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.wpattern.mutrack.simple.utils.AppContext;

@SpringBootApplication
public class AppMain {

	public static void main(String[] args) {
		SpringApplication.run(AppContext.class, args);
	}

}
