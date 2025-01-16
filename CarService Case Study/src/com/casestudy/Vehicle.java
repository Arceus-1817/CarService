package com.casestudy;

import java.util.HashMap;
import java.util.Objects;

public class Vehicle {
	protected String Reg_no;
	protected String Company;
	protected String model;
	
//	
//	public HashMap<String,Object> toMap(){
//		 HashMap<String, Object> VehicleSet = new HashMap<>();
//		 VehicleSet.put("regnumber", this.Reg_no);
//		 VehicleSet.put("Company", this.Company);
//		 VehicleSet.put("model", this.model);
//		return VehicleSet;
//	}
	
	
	public String getReg_no() {
		return Reg_no;
	}
	public void setReg_no(String reg_no) {
		Reg_no = reg_no;
	}
	public String getCompany() {
		return Company;
	}
	public void setCompany(String company) {
		Company = company;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	@Override
	public String toString() {
		return "Vehicle [Reg_no=" + Reg_no + ", Company=" + Company + ", model=" + model + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(Reg_no);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		return Objects.equals(Reg_no, other.Reg_no);
	}
	public Vehicle(String reg_no, String company, String model) {
		Reg_no = reg_no;
		Company = company;
		this.model = model;
	}
	
	
	
}
