package com.example.demo;

import jakarta.persistence.*;

@Entity
public class Guest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String g_name;
	private String date;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getG_name() {
		return g_name;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Guest(String g_name, String date) {
		super();
		this.g_name = g_name;
		this.date = date;
	}
	public Guest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
