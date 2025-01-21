package com.casestudy;

import java.util.GregorianCalendar;

public class Bill {

	
	public static final double gst = 12.6;
	public double Amount;
	Customer customer;
	Vehicle vehicle;
	GregorianCalendar  C=new GregorianCalendar();

	
	public void setAmount(double amount) {
		Amount = amount;
	}

	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public GregorianCalendar getC() {
		return C;
	}
	public void setC(GregorianCalendar c) {
		C = c;
	}
	public double getAmount() {
		return Amount;
	}
	@Override
	public String toString() {
		return "Bill [Amount=" + Amount + ", customer=" + customer + ", vehicle=" + vehicle + ", C=" + C + "]";
	}
	
	
	
}
