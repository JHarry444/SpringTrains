package com.qa.demo.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.demo.data.domain.Train;
import com.qa.demo.dto.TrainDTO;
import com.qa.demo.services.TrainService;

@RestController
@RequestMapping("/train")
public class TrainController {

	private TrainService service;

	public TrainController(TrainService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public TrainDTO create(@RequestBody Train train) {
		return this.service.create(train);
	}

	@GetMapping("/read")
	public List<Train> read() {
		return this.service.read();
	}
	
	@PutMapping("/update/{id}")
	public Train update(@PathParam("name") String name, @PathParam("colour") String colour, @PathVariable Long id) {
		return this.service.update(name, colour, id);
	}

	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable Long id) {
		return this.service.delete(id);
	}

}
