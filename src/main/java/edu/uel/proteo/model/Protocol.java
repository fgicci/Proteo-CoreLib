package edu.uel.proteo.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.JoinColumn;

@Entity
@Table(name = "protocol")
public class Protocol extends Record {

	private String name;
	private String description;
	
	@Enumerated(EnumType.STRING)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private ProtocolType type;
	
	@Enumerated(EnumType.STRING)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Sport sport;
	
	@ManyToMany
	@JoinTable(name = "protocol_characteristic",
		joinColumns = @JoinColumn(name = "protocol_id", referencedColumnName = "id", nullable = false, updatable = false),
		inverseJoinColumns = @JoinColumn(name = "characteristic_id", referencedColumnName = "id", nullable = false, updatable = false))
	@OrderBy("id ASC")
	private Set<Characteristic> characteristics;
	
	public Protocol() {}

	public Protocol(String name, String description, ProtocolType type, Sport sport, Set<Characteristic> characteristics) {
		super();
		this.name = name;
		this.description = description;
		this.type = type;
		this.sport = sport;
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

	public ProtocolType getType() {
		return type;
	}

	public void setType(ProtocolType type) {
		this.type = type;
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	public Set<Characteristic> getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(Set<Characteristic> characteristics) {
		this.characteristics = characteristics;
	}
	
	public Characteristic addCharacteristic(Characteristic characteristic) {
		getCharacteristics().add(characteristic);
		return characteristic;
	}
	
	public Characteristic removeCharacteristic(Characteristic characteristic) {
		getCharacteristics().remove(characteristic);
		return characteristic;
	}
}
