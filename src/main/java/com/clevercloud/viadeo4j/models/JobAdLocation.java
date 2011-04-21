/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.clevercloud.viadeo4j.models;

/**
 *
 * @author Julien Durillon
 */
public class JobAdLocation {
    private String city;
    private String country;
    private String area;

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
}
