package timenoter.login;
        
import java.io.Serializable;
import timenoter.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fitexmage
 */
public class Account implements Serializable{

    private int userID;
    private String username;
    private String password;

    public Account(int userID, String username, String password) {
        this.userID = userID;
        this.username = username;
        this.password = password;
    }
    
    public Account(){
        
    }

    public void update(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void update() {
        this.username = User.getTheUser().getTheAccount().username;
        this.password = User.getTheUser().getTheAccount().password;
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
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
