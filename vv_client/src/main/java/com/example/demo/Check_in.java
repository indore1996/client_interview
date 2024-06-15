package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Check_in {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String h_name;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Guest> guests = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getH_name() {
		return h_name;
	}

	public void setH_name(String h_name) {
		this.h_name = h_name;
	}

	public List<Guest> getGuests() {
		return guests;
	}

	public void setGuests(List<Guest> guests) {
		this.guests = guests;
	}

	public Check_in(String h_name, List<Guest> guests) {
		super();
		this.h_name = h_name;
		this.guests = guests;
	}

	public Check_in() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
