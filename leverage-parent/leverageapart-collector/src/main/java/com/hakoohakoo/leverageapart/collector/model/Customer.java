package com.hakoohakoo.leverageapart.collector.model;

import org.springframework.data.annotation.Id;

public class Customer {
	private int id;
	private final String name;
	
	@Id
	public int getId() {
		return id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Customer(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return String.format("id = %d, name = %s", id, name);
	}
}
