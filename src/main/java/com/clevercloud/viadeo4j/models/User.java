/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.clevercloud.viadeo4j.models;

import java.io.Serializable;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Julien Durillon
 */
public class User implements Serializable {

    public static final String TYPE = "USER";

    private String nickname;

    private String headline;

    private Gender gender;

    private String first_name;

    private String last_name;

    private URL picture_small;

    private URL picture_large;

    private String presentation;

    private String interest;

    private Location location;

    private String language;

    private Integer distance;

    protected String id;

    protected String name;

    protected URL link;

    protected Date updated_time; // yyyy-dd-mmThh:mm:ssZ 2008-10-04T12:56:12+02:00

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

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public String getFirst_name() {
        return first_name;
    }
    
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interests) {
        this.interest = interests;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public URL getPicture_large() {
        return picture_large;
    }

    public void setPicture_large(URL picture_large) {
        this.picture_large = picture_large;
    }

    public URL getPicture_small() {
        return picture_small;
    }

    public void setPicture_small(URL picture_small) {
        this.picture_small = picture_small;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    @Override
    public String toString() {
        return "User{" + "nickname=" + nickname + "headline=" + headline + "gender=" + gender + "first_name=" + first_name + "last_name=" + last_name + "picture_small=" + picture_small + "picture_large=" + picture_large + "presentation=" + presentation + "interest=" + interest + "location=" + location + "language=" + language + "distance=" + distance + "id=" + id + "name=" + name + "link=" + link + "updated_time=" + updated_time + "unknownField=" + unknownField + '}';
    }
}
