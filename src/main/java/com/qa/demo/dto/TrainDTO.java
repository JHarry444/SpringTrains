package com.qa.demo.dto;

public class TrainDTO {

	private Long id; 
	
	private String name;

	private String colour;

	public TrainDTO(Long id, String name, String colour) {
		super();
		this.id = id;
		this.name = name;
		this.colour = colour;
	}
	
	public TrainDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

}