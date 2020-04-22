package com.qa.demo.data.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TrainYard {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@OneToMany(mappedBy = "trainYard", fetch = FetchType.EAGER)
	private Set<Train> trains;

	public TrainYard() {
	}

	public TrainYard(String name) {
		super();
		this.name = name;
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

	public Set<Train> getTrains() {
		return trains;
	}

	public void setTrains(Set<Train> trains) {
		this.trains = trains;
	}

}
