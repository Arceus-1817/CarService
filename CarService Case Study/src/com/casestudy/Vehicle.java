package com.casestudy;


public class Vehicle {
	protected String Reg_no;
	protected String Company;
	protected String model;
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
	
	
	
}
