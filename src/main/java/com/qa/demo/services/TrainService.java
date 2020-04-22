package com.qa.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.qa.demo.data.domain.Train;
import com.qa.demo.data.repo.TrainRepo;
import com.qa.demo.dto.TrainDTO;
import com.qa.demo.exceptions.TrainNotFoundException;

@Service
public class TrainService {

	private TrainRepo repo;

	private ModelMapper mapper;

	public TrainService(TrainRepo repo, ModelMapper mapper) {
		this.repo = repo;
		this.mapper = mapper;
	}

	private TrainDTO mapToDTO(Train train) {
		return this.mapper.map(train, TrainDTO.class);
	}

	public TrainDTO create(Train train) {
		Train savedTrain = this.repo.save(train);
		TrainDTO dto = mapToDTO(savedTrain);
		return dto;
	}

	public List<TrainDTO> read() {
		//convert List<Train> -> List<TrainDTO>
		return this.repo
				.findAll()
				.stream()
				.map((train) -> this.mapToDTO(train))
				//.map(this::mapToDTO)
				.collect(Collectors.toList());
	}

	public Train update(String name, String colour, Long id) {
		Train train = this.repo.findById(id).orElseThrow(() -> new TrainNotFoundException());
		train.setColour(colour);
		train.setName(name);
		return this.repo.save(train);
	}

	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return this.repo.existsById(id);
	}

}
