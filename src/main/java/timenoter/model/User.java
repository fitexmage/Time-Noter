package timenoter.model;

import timenoter.model.Recommendation;
import timenoter.model.Schedule;
import timenoter.model.PersonalInfo;
import timenoter.model.Account;
import timenoter.model.Friend;
import timenoter.model.Data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fitexmage
 */
public class User {
    
    private static User theUser;
    private Account theAccount;
    private PersonalInfo thePersonalInfo;
    private Schedule theSchedule;
    private Friend theFriend;
    private Recommendation theRecommendation;

    public User(int userID) {
        theAccount = Data.getTheData().getTheAccountListClass().getTheAccount(userID);
        thePersonalInfo = Data.getTheData().getThePersonalInfoClass().getThePersonalInfo(userID);
        theSchedule = Data.getTheData().getTheScheduleListClass().getTheSchedule(userID);
        theFriend = Data.getTheData().getTheFriendListClass().getTheFriend(userID);
        theRecommendation = Data.getTheData().getTheRecommmendationListClass().getTheRecommendation(userID);
    }

    /**
     * @return the theUser
     */
    public static User getTheUser() {
        return theUser;
    }

    /**
     * @param aTheUser the theUser to set
     */
    public static void setTheUser(User aTheUser) {
        theUser = aTheUser;
    }

    /**
     * @return the theAccount
     */
    public Account getTheAccount() {
        return theAccount;
    }

    /**
     * @param theAccount the theAccount to set
     */
    public void setTheAccount(Account theAccount) {
        this.theAccount = theAccount;
    }

    /**
     * @return the thePersonalInfo
     */
    public PersonalInfo getThePersonalInfo() {
        return thePersonalInfo;
    }

    /**
     * @param thePersonalInfo the thePersonalInfo to set
     */
    public void setThePersonalInfo(PersonalInfo thePersonalInfo) {
        this.thePersonalInfo = thePersonalInfo;
    }

    /**
     * @return the theSchedule
     */
    public Schedule getTheSchedule() {
        return theSchedule;
    }

    /**
     * @param theSchedule the theSchedule to set
     */
    public void setTheSchedule(Schedule theSchedule) {
        this.theSchedule = theSchedule;
    }

    /**
     * @return the theFriend
     */
    public Friend getTheFriend() {
        return theFriend;
    }

    /**
     * @param theFriend the theFriend to set
     */
    public void setTheFriend(Friend theFriend) {
        this.theFriend = theFriend;
    }

    /**
     * @return the theRecommendation
     */
    public Recommendation getTheRecommendation() {
        return theRecommendation;
    }

    /**
     * @param theRecommendation the theRecommendation to set
     */
    public void setTheRecommendation(Recommendation theRecommendation) {
        this.theRecommendation = theRecommendation;
    }
}
