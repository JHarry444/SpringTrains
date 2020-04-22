package com.qa.demo.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Train {

	@Id
	@GeneratedValue
	private long id;

	private String name;
	
//	@Column(nullable = false, name = "colour")
	private String colour;
	
	@ManyToOne
	private TrainYard trainYard;

	public Train() {
		super();
	}

	public Train(String name, String colour) {
		super();
		this.name = name;
		this.colour = colour;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	@Override
	public String toString() {
		return "Train [name=" + name + ", colour=" + colour + "]";
	}

	public TrainYard getTrainYard() {
		return trainYard;
	}

	public void setTrainYard(TrainYard trainYard) {
		this.trainYard = trainYard;
	}
	
	

}
