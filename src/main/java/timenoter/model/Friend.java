package timenoter.model;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fitexmage
 */
public class Friend {
    
    private int userID;
    private HashMap<Integer, Integer> friendIDList;
    private ArrayList<Integer> requestIDList;
    
    public Friend(int userID, HashMap<Integer, Integer> friendIDList, ArrayList<Integer> requestIDList){
        this.userID = userID;
        this.friendIDList = friendIDList;
        this.requestIDList = requestIDList;
    }
    
    public Friend(){
        
    }
    
    public void update(HashMap<Integer, Integer> friendIDList, ArrayList<Integer> requestIDList) {
        this.friendIDList = friendIDList;
        this.requestIDList = requestIDList;
    }

    public void update() {
        this.friendIDList = User.getTheUser().getTheFriend().friendIDList;
        this.requestIDList = User.getTheUser().getTheFriend().requestIDList;
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
     * @return the friendIDList
     */
    public HashMap<Integer, Integer> getFriendIDList() {
        return friendIDList;
    }

    /**
     * @param friendIDList the friendIDList to set
     */
    public void setFriendIDList(HashMap<Integer, Integer> friendIDList) {
        this.friendIDList = friendIDList;
    }

    /**
     * @return the requestIDList
     */
    public ArrayList<Integer> getRequestIDList() {
        return requestIDList;
    }

    /**
     * @param requestIDList the requestIDList to set
     */
    public void setRequestIDList(ArrayList<Integer> requestIDList) {
        this.requestIDList = requestIDList;
    }
}
