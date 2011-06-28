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
public class Connection implements Serializable {
    private String name;
    private String connection;

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
