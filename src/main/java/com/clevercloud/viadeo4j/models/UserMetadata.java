/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clevercloud.viadeo4j.models;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Julien Durillon
 */
public class UserMetadata {

    public static final String TYPE = "USER METADATA";

    private List<Connection> connections;

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

    public List<Connection> getConnections() {
        return connections;
    }

    public void setConnections(List<Connection> connections) {
        this.connections = connections;
    }
}
