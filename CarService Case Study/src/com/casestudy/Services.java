package com.casestudy;

import java.io.Serializable;
import java.util.Objects;

public class Services implements Serializable{

	private static final long serialVersionUID = 1L;
	private String ServiceId;
	private String description;

	
	public Services(String next) {
		ServiceId = next;
		this.description = next;
	}

	public String getServiceId() {
		return ServiceId;
	}
	public void setServiceId(String serviceId) {
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