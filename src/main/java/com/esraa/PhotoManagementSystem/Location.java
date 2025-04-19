package com.esraa.PhotoManagementSystem;

public class Location {
    private String Country;
    private String City;
    private double latitude;
    private double longitude;


    public Location(String country, String city) {
        this.Country = country;
        this.City = city;
    }


    public Location(double lat, double lon) {
        this.latitude = lat;
        this.longitude = lon;
    }

    public String getCountry() {
        return Country;
    }

    public String getCity() {
        return City;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "Location{" +
                "Country='" + Country + '\'' +
                ", City='" + City + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
