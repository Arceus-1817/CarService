package com.casestudy;

import java.io.Serializable;
import java.util.Objects;

public class Customer implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	protected String name;
	protected String ph_no;
	protected String C_address;
	
	public Customer(String name, String ph_no, String c_address) {
		this.name = name;
		this.ph_no = ph_no;
		C_address = c_address;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPh_no() {
		return ph_no;
	}
	public void setPh_no(String ph_no) {
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


	@Override
	public int hashCode() {
		return Objects.hash(ph_no);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(ph_no, other.ph_no);
	}
	
	
	
	
	
}
