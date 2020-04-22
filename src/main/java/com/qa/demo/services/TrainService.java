package com.qa.demo.services;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.demo.data.domain.Train;
import com.qa.demo.data.repo.TrainRepo;
import com.qa.demo.exceptions.TrainNotFoundException;

@Service
public class TrainService {

	private TrainRepo repo;

	public TrainService(TrainRepo repo) {
		this.repo = repo;
	}
	
	public Train create(Train train) {
		return this.repo.save(train);
	}
	
	public List<Train> read() {
		return this.repo.findAll();
	}
	
	public Train update(String name, String colour, Long id) {
		Train train = this.repo
				.findById(id)
				.orElseThrow(TrainNotFoundException::new);
		train.setColour(colour);
		train.setName(name);
		return this.repo.save(train);
	}
		
	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return this.repo.existsById(id);
	}

}
