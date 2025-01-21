package com.casestudy;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Services implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//protected int serviceId;
	protected String S_name;
	protected Vehicle vehicle;
	protected List<Parts> partsused;
	protected double labourCharges;
	protected double oilcost;
	
	
	
	public Services(String s_name, double labourCharges) {
		S_name = s_name;
		this.labourCharges = labourCharges;	}

	//	public  Services (String S_name,Vehicle vehicle,List<Parts> partsused, double labourcharges,double oilcost) {
//		this.S_name=S_name;
//		this.vehicle=vehicle;
//		this.partsused=partsused;
//		this.labourCharges=labourcharges;
//		this.oilcost=oilcost;
//		
//		
//	}
	
	
	
	public String getS_name() {
		return S_name;
	}
	
//	public int getServiceId() {
//		return serviceId;
//	}

//	public void setServiceId(int serviceId) {
//		this.serviceId = serviceId;
//	}

	public void setS_name(String s_name) {
		S_name = s_name;
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

	
	@Override
	public String toString() {
		return "Services [serviceId="  + ", S_name=" + S_name + ", vehicle=" + vehicle + ", partsused="
				+ partsused + ", labourCharges=" + labourCharges + ", oilcost=" + oilcost + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(S_name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Services other = (Services) obj;
		return Objects.equals(S_name, other.S_name);
	}

	
	
	
}
