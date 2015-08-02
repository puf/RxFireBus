package com.company;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class Vehicle {
    String dirTag;
    long id;
    long heading;
    String lat;
    String lon;
    boolean predictable;
    String routeTag;
    long secsSinceReport;
    long speedKmHr;
    Date timestamp;
    String vtype;
    long leadingVehicleId;
    //"dirTag":"60___I_F00","heading":171,"id":2,"lat":37.7854,"lon":-122.40756,"predictable":true,"routeTag":"60",
    // "secsSinceReport":2,"speedKmHr":0,"timestamp":1438366207486,"vtype":"bus"}

    @Override
    public String toString() {
        return "Vehicle{" +
                "dirTag=" + dirTag +
                ", id=" + id +
                ", heading=" + heading +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                ", predictable=" + predictable +
                ", routeTag='" + routeTag + '\'' +
                ", secsSinceReport=" + secsSinceReport +
                ", speedKmHr=" + speedKmHr +
                ", timestamp=" + timestamp +
                ", vtype='" + vtype + '\'' +
                ", leadingVehicleId=" + leadingVehicleId +
                '}';
    }

    public String getDirTag() {
        return dirTag;
    }

    public long getId() {
        return id;
    }

    public long getHeading() {
        return heading;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }

    public boolean isPredictable() {
        return predictable;
    }

    public String getRouteTag() {
        return routeTag;
    }

    public long getSecsSinceReport() {
        return secsSinceReport;
    }

    public long getSpeedKmHr() {
        return speedKmHr;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getVtype() {
        return vtype;
    }

    public long getLeadingVehicleId() {
        return leadingVehicleId;
    }
}
