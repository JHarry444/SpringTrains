package com.qa.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.demo.data.domain.Train;
import com.qa.demo.data.repo.TrainRepo;

@Service
public class TrainService {

	
	private TrainRepo repo;

	public TrainService(TrainRepo repo) {
		this.repo = repo;
	}
	
	public void create(Train train) {
		this.repo.save(train);
	}

}
