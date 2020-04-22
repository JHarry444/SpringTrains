package com.qa.demo.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.demo.data.domain.Train;
import com.qa.demo.data.domain.TrainYard;
import com.qa.demo.services.TrainYardService;

@RestController
@RequestMapping("/yard")
public class TrainYardController {

	private TrainYardService service;

	public TrainYardController(TrainYardService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public TrainYard create(@RequestBody TrainYard trainYard) {
		return this.service.create(trainYard);
	}
	
	@PatchMapping("/addTrain/{trainID}/{yardID}")
	public void addTrain(Long trainID, Long yardID) {
		this.service.addTrain(trainID, yardID);
	}

	@GetMapping("/read")
	public List<TrainYard> read() {
		return this.service.read();
	}
	
	@PutMapping("/update/{id}")
	public TrainYard update(@PathParam("name") String name, @PathVariable Long id) {
		return this.service.update(name, id);
	}

	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable Long id) {
		return this.service.delete(id);
	}

}
