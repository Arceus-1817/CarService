package com.casestudy;

import java.util.List;

public class Services {

	private Vehicle vehicle;
	private List<Parts> partsused;
	private double labourCharges;
	private double oilcost;
	
	public  Services (Vehicle vehicle,List<Parts> partsused, double labourcharges,double oilcost) {
		this.vehicle=vehicle;
		this.partsused=partsused;
		this.labourCharges=labourcharges;
		this.oilcost=oilcost;
		
		
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public List<Parts> getPartsused() {
		return partsused;
	}

	public void setPartsused(List<Parts> partsused) {
		this.partsused = partsused;
	}

	public double getLabourCharges() {
		return labourCharges;
	}

	public void setLabourCharges(double labourCharges) {
		this.labourCharges = labourCharges;
	}

	public double getOilcost() {
		return oilcost;
	}

	public void setOilcost(double oilcost) {
		this.oilcost = oilcost;
	}
	
	
}
