/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clevercloud.viadeo4j.models;

import java.net.URL;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author Julien Durillon
 */
public class Company {

    public static final String TYPE = "COMPANY";

    private String description;

    private String industry;

    private Location location;

    private String size;

    protected String id;

    protected String name;

    protected URL link;

    protected Date updated_time; // yyyy-dd-mmThh:mmTZD <-- WTF?

    protected Map<String, String> unknownField;

    public Map<String, String> getUnknownField() {
        return unknownField;
    }

    public void setUnknownField(Map<String, String> unknownField) {
        this.unknownField = unknownField;
    }
    
    /**
     * Get a field on name <strong>field</strong> from unknownField.
     * @param field the wanted field.
     */
    public String get(String field) {
        return this.unknownField.get(field);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public URL getLink() {
        return link;
    }

    public void setLink(URL link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getUpdated_time() {
        return updated_time;
    }

    public void setUpdated_time(Date updated_time) {
        this.updated_time = updated_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
