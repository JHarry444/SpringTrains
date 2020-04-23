package com.qa.demo.data.domain;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((colour == null) ? 0 : colour.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((trainYard == null) ? 0 : trainYard.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Train other = (Train) obj;
		if (colour == null) {
			if (other.colour != null)
				return false;
		} else if (!colour.equals(other.colour))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (trainYard == null) {
			if (other.trainYard != null)
				return false;
		} else if (!trainYard.equals(other.trainYard))
			return false;
		return true;
	}

	public TrainYard getTrainYard() {
		return trainYard;
	}

	public void setTrainYard(TrainYard trainYard) {
		this.trainYard = trainYard;
	}

}
