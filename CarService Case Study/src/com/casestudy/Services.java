package com.casestudy;

import java.io.Serializable;
import java.util.Objects;

public class Services implements Serializable {

    private static final long serialVersionUID = 1L;
    private Double ServiceId;
    private String description;

    public Services(Double serviceId, String description) {
        this.ServiceId = serviceId;
        this.description = description;
    }

    public Double getServiceId() {
        return ServiceId;
    }

    public void setServiceId(Double serviceId) {
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
        if (obj == null || getClass() != obj.getClass())
            return false;
        Services other = (Services) obj;
        return Objects.equals(ServiceId, other.ServiceId) &&
               Objects.equals(description, other.description);
    }
}
