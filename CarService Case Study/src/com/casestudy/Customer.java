package com.casestudy;


public class Customer
{
	protected String name;
	protected double ph_no;
	protected String C_address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPh_no() {
		return ph_no;
	}
	public void setPh_no(double ph_no) {
		this.ph_no = ph_no;
	}
	public String getC_address() {
		return C_address;
	}
	public void setC_address(String c_address) {
		C_address = c_address;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", ph_no=" + ph_no + ", C_address=" + C_address + "]";
	}
	
	
}
