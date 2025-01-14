package com.casestudy;

import java.io.Serializable;
import java.util.Objects;

public class Parts implements Serializable {

	private String PartId;
	private String PartName;
	private double Prize;
	
	
	
	public  Parts(String partId, String partName, double prize) {
		PartId = partId;
		PartName = partName;
		this.Prize = prize;
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
		return Prize;
	}
	public  void setPrize(double prize) {
		 Prize= prize;
	}
	@Override
	public String toString() {
		return "Parts [PartId=" + PartId + ", PartName=" + PartName + ", prize=" + Prize + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(PartId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parts other = (Parts) obj;
		return Objects.equals(PartId, other.PartId);
	}
	
	
	
}

