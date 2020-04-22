package com.qa.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.demo.data.domain.TrainYard;
import com.qa.demo.data.repo.TrainYardRepo;
import com.qa.demo.exceptions.TrainYardNotFoundException;

@Service
public class TrainYardService {

	private TrainYardRepo repo;

	public TrainYardService(TrainYardRepo repo) {
		this.repo = repo;
	}
	
	public TrainYard create(TrainYard train) {
		return this.repo.save(train);
	}
	
	public List<TrainYard> read() {
		return this.repo.findAll();
	}
	
	public TrainYard update(String name, Long id) {
		TrainYard train = this.repo
				.findById(id)
				.orElseThrow(() -> new TrainYardNotFoundException());
		train.setName(name);
		return this.repo.save(train);
	}
		
	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return this.repo.existsById(id);
	}

	public void addTrain(Long trainID, Long yardID) {
//		Train 
		
	}

}
