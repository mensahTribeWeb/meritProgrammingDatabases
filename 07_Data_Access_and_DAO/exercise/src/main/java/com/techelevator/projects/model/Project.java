package com.techelevator.projects.model;

import java.time.LocalDate;

public class Project {
	private int id;
	private String name;
	private LocalDate fromDate;
	private LocalDate toDate;

	public Project() {}

	public Project(int id, String name, LocalDate fromDate, LocalDate toDate) {
		this.id = id;
		this.name = name;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	@Override
	public String toString() {
		return name;
	}
}
