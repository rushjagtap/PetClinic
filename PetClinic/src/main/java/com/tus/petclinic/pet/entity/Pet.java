package com.tus.petclinic.pet.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
public class Pet implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int petId;
	
	@Column(nullable = false)
	private String name;
	
	@Column
	private String birthdate;
	
	@Column
	private String type;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "petId")
	private  Set<Visit> visits;
	/**
	 * @return the petId
	 */
	public int getPetId() {
		return petId;
	}

	/**
	 * @param petId the petId to set
	 */
	public void setPetId(int petId) {
		this.petId = petId;
	}

	/**
	 * @return the visits
	 */
	public Set<Visit> getVisits() {
		return visits;
	}

	/**
	 * @param visits the visits to set
	 */
	public void setVisits(Set<Visit> visits) {
		this.visits = visits;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return petId;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.petId = id;
	}
	/**
	 * @return the birthdate
	 */
	public String getBirthdate() {
		return birthdate;
	}
	/**
	 * @param birthdate the birthdate to set
	 */
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @return the visits
	 */
	
	public Pet(String name, String birthdate, String type, Set<Visit> visits) {
		this.name = name;
		this.birthdate = birthdate;
		this.type = type;
		//this.visits = visits;
	}
	public Pet()
	{
	
	}
	
}
