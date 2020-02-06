package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="HERO")
public class Hero {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="heroSequence")
	@SequenceGenerator(name="heroSequence", sequenceName="HERO_SEQ", allocationSize=1)
	@Column(name="H_ID")
	private int id;
	
	@Column(name="H_NAME")
	private String name;
	
	@Column(name="H_SUPER_POWER")
	private String superPower;
	
	@Column(name="H_HAS_CAPE")
	private boolean hasCape;
	
	public Hero() {}

	public Hero(String name, String superPower, boolean hasCape) {
		this.name = name;
		this.superPower = superPower;
		this.hasCape = hasCape;
	}
	
	public Hero(int id, String name, String superPower, boolean hasCape) {
		this.id = id;
		this.name = name;
		this.superPower = superPower;
		this.hasCape = hasCape;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSuperPower() {
		return superPower;
	}

	public void setSuperPower(String superPower) {
		this.superPower = superPower;
	}

	public boolean isHasCape() {
		return hasCape;
	}

	public void setHasCape(boolean hasCape) {
		this.hasCape = hasCape;
	}

	@Override
	public String toString() {
		return "Hero [id=" + id + ", name=" + name + ", superPower=" + superPower + ", hasCape=" + hasCape + "]";
	}
}
