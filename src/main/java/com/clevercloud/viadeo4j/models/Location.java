package com.clevercloud.viadeo4j.models;

/**
 *
 * @author Julien Durillon
 */
public class Location {
    private String city;

    private String zipcode;

    private String country;

    private String area;

    private String timezone;

    private Double latitude;

    private Double longitude;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "Location{" + "city=" + city + "zipcode=" + zipcode + "country=" + country + "area=" + area + "timezone=" + timezone + "latitude=" + latitude + "longitude=" + longitude + '}';
    }
}
