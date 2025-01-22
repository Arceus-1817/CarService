package com.casestudy;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;



public abstract class Services implements Serializable{

	private static final long serialVersionUID = 1L;
	private String description;

<<<<<<< HEAD
	
	public Services(int nextInt, String next) {
		ServiceId = nextInt;
		this.description = next;
=======
	public Services() {
		this("");
	}
	public Services( String next) {
		this.description = description;
>>>>>>> fafa134c7105e582897fd5989b823724c82b151c
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double price() {
		return price();
	}
	@Override
	public String toString() {
		return "Services [getDescription()=" + getDescription() + ", price()=" + price() + "]";
	}
	
	
}