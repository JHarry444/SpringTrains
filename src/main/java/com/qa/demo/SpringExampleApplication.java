package com.qa.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.qa.demo.data.domain.Train;
import com.qa.demo.data.repo.TrainRepo;
import com.qa.demo.services.TrainService;

@SpringBootApplication
public class SpringExampleApplication {

	// bean -> managed object
	// IoC -> inversion of control -> program manages objects for the dev
	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(SpringExampleApplication.class, args);
		TrainService service = ac.getBean(TrainService.class);
		service.create(new Train("Thomas", "Blue"));
	}

}
