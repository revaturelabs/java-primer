package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.SequenceGenerator;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

/* For Stored Procedures */
@NamedStoredProcedureQuery(name = "INSERT_JEDI", 
procedureName = "INSERT_JEDI",
parameters = {
    @StoredProcedureParameter(mode = ParameterMode.IN, name = "ID", type = Integer.class),
    @StoredProcedureParameter(mode = ParameterMode.IN, name = "NAME", type = String.class),
    @StoredProcedureParameter(mode = ParameterMode.IN, name = "SABER_COLOR", type = String.class)
})
/* Jedi Business Object */
@Entity
@Table(name="JEDI")
public class Jedi {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="JEDI_SEQ")
	@SequenceGenerator(name="JEDI_SEQ", sequenceName="JEDI_SEQ", allocationSize=1)
	@Column(name="J_ID")
	private int id;
	
	@Column(name="J_NAME")
	private String name;
	
	@Column(name="J_SABER_COLOR")
	private String saberColor;
	
	public Jedi() {}
	
	public Jedi(String name) {
		this.name = name;
	}
	
	public Jedi(int id, String name, String saberColor) {
		this.id = id;
		this.name = name;
		this.saberColor = saberColor;
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
	
	public String getSaberColor() {
		return saberColor;
	}
	
	public void setSaberColor(String saberColor) {
		this.saberColor = saberColor;
	}

	@Override
	public String toString() {
		return "Jedi [id=" + id + ", name=" + name + ", saberColor=" + saberColor + "]";
	}
}
