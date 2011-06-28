/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.clevercloud.viadeo4j.models;

import java.io.Serializable;

/**
 *
 * @author Julien Durillon
 */
public class JobAdLocation implements Serializable {
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
