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
public class JobAd {

    public static final String TYPE = "JOB AD";

    private JobAdData data;

    protected String id;

    protected String name;

    protected URL link;

    protected Date updated_time; // yyyy-dd-mmThh:mmTZD

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

    public JobAdData getData() {
        return data;
    }

    public void setData(JobAdData data) {
        this.data = data;
    }
}
