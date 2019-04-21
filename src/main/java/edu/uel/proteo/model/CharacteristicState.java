package edu.uel.proteo.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "characteristic_state")
public class CharacteristicState extends Record {

	private String name;
	private String description;
	
	@Enumerated(EnumType.STRING)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private CharacteristicStateType type;
	
	private Double value;
	
	@ManyToMany(mappedBy = "states")
	@JsonIgnore
	Set<Characteristic> characteristics;
	
	public CharacteristicState() {}
	
	public CharacteristicState(String name, String description, CharacteristicStateType type, Double value, Set<Characteristic> characteristics) {
		this.name = name;
		this.description = description;
		this.type = type;
		this.value = value;
		this.characteristics = characteristics;		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Set<Characteristic> getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(Set<Characteristic> characteristics) {
		this.characteristics = characteristics;
	}
}
