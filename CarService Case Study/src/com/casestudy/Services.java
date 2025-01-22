package com.casestudy;

import java.io.Serializable;
import java.util.Objects;

public class Services implements Serializable{

	private static final long serialVersionUID = 1L;
	private int ServiceId;
	private String description;

	
	public Services(int nextInt, String next) {
		ServiceId = nextInt;
		this.description = next;
	}

	public int getServiceId() {
		return ServiceId;
	}
	public void setServiceId(int serviceId) {
		ServiceId = serviceId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Service [ServiceId=" + ServiceId + ", description=" + description + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ServiceId, description);
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
		return ServiceId == other.ServiceId && Objects.equals(description, other.description);
	}
	
	
	
}