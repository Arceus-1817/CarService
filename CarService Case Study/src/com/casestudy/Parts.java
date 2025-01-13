package com.casestudy;

import java.io.Serializable;

public class Parts implements Serializable {

	private String PartId;
	private String PartName;
	private double prize;
	
	
	
	public Parts(String partId, String partName, double prize) {
		PartId = partId;
		PartName = partName;
		this.prize = prize;
	}
	public String getPartId() {
		return PartId;
	}
	public void setPartId(String partId) {
		PartId = partId;
	}
	public String getPartName() {
		return PartName;
	}
	public void setPartName(String partName) {
		PartName = partName;
	}
	public double getPrize() {
		return prize;
	}
	public void setPrize(double prize) {
		this.prize = prize;
	}
	@Override
	public String toString() {
		return "Parts [PartId=" + PartId + ", PartName=" + PartName + ", prize=" + prize + "]";
	}
	
	
	
}

