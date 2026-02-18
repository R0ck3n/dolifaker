package com.dolibarrfaker.dolifaker.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true) // ⚡ ignore tous les champs que tu n'as pas dans le DTO
public class User {

    @JsonProperty("id")
    private String id;

    @JsonProperty("firstname")
    private String firstname;

    @JsonProperty("lastname")
    private String lastname;

    // getters et setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }

    public String getFullName() {
        String f = (firstname != null) ? firstname : "";
        String l = (lastname != null) ? lastname : "";
        return (f + " " + l).trim();
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", firstname='" + firstname + '\'' +
               ", lastname='" + lastname + '\'' + '}';
    }
}
