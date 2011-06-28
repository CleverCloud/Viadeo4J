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
public class JobAdData implements Serializable {

    private String title;

    private String description;

    private String category;

    private JobAdLocation location;

    private String education_level;

    private String experience;

    private String contract_type;

    private String reference;

    private Company company;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getContract_type() {
        return contract_type;
    }

    public void setContract_type(String contract_type) {
        this.contract_type = contract_type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEducation_level() {
        return education_level;
    }

    public void setEducation_level(String education_level) {
        this.education_level = education_level;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public JobAdLocation getLocation() {
        return location;
    }

    public void setLocation(JobAdLocation location) {
        this.location = location;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
