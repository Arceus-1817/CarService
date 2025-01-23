package com.casestudy;

import java.io.Serializable;
import java.util.Objects;

public class Parts implements Serializable {
	private static final long serialVersionUID = -7903184526549624082L;
	private String PartId;
	private String PartName;
	private double Price;
	
	
	
	public  Parts(String partId, String partName, double price) {
		PartId = partId;
		PartName = partName;
		this.Price = Price;
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
	
	public  void setPrize(double prize) {
		Price= Price;
	}
	@Override
	public String toString() {
		return "Parts [PartId=" + PartId + ", PartName=" + PartName + ", prize=" + Price + "]";
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
	public double getPrice() {
		return Price;
	}
	
	
	
}

