/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timenoter.user;

import timenoter.User;

/**
 *
 * @author fitexmage
 */
public class PersonalInfo {
    
    private int userID;
    private String name;
    private String email;
    private String description;
    
    public PersonalInfo(int userID, String name, String email, String description){
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.description = description;
    }
    
    public PersonalInfo(){
        
    }
    
    public void update(String name, String email, String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public void update() {
        this.name = User.getTheUser().getThePersonalInfo().name;
        this.email = User.getTheUser().getThePersonalInfo().email;
        this.description = User.getTheUser().getThePersonalInfo().description;
    }

    /**
     * @return the userID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
