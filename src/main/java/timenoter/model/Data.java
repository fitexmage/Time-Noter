package timenoter.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author fitexmage
 */
public class Data {

    private static Data theData;
    private AccountList theAccountListClass;
    private PersonalInfoList thePersonalInfoClass;
    private ScheduleList theScheduleListClass;
    private FriendList theFriendListClass;
    private RecommendationList theRecommmendationListClass;

    public Data() {
        theAccountListClass = new AccountList();
        thePersonalInfoClass = new PersonalInfoList();
        theScheduleListClass = new ScheduleList();
        theFriendListClass = new FriendList();
        theRecommmendationListClass = new RecommendationList();
    }
    
    public void saveAll(){
        theAccountListClass.save();
        thePersonalInfoClass.save();
        theScheduleListClass.save();
        theFriendListClass.save();
        theRecommmendationListClass.save();
    }

    /**
     * @return the theData
     */
    public static Data getTheData() {
        return theData;
    }

    /**
     * @param aTheData the theData to set
     */
    public static void setTheData(Data aTheData) {
        theData = aTheData;
    }

    /**
     * @return the theAccountListClass
     */
    public AccountList getTheAccountListClass() {
        return theAccountListClass;
    }

    /**
     * @param theAccountListClass the theAccountListClass to set
     */
    public void setTheAccountListClass(AccountList theAccountListClass) {
        this.theAccountListClass = theAccountListClass;
    }

    /**
     * @return the thePersonalInfoClass
     */
    public PersonalInfoList getThePersonalInfoClass() {
        return thePersonalInfoClass;
    }

    /**
     * @param thePersonalInfoClass the thePersonalInfoClass to set
     */
    public void setThePersonalInfoClass(PersonalInfoList thePersonalInfoClass) {
        this.thePersonalInfoClass = thePersonalInfoClass;
    }

    /**
     * @return the theScheduleListClass
     */
    public ScheduleList getTheScheduleListClass() {
        return theScheduleListClass;
    }

    /**
     * @param theScheduleListClass the theScheduleListClass to set
     */
    public void setTheScheduleListClass(ScheduleList theScheduleListClass) {
        this.theScheduleListClass = theScheduleListClass;
    }

    /**
     * @return the theFriendListClass
     */
    public FriendList getTheFriendListClass() {
        return theFriendListClass;
    }

    /**
     * @param theFriendListClass the theFriendListClass to set
     */
    public void setTheFriendListClass(FriendList theFriendListClass) {
        this.theFriendListClass = theFriendListClass;
    }

    /**
     * @return the theRecommmendationListClass
     */
    public RecommendationList getTheRecommmendationListClass() {
        return theRecommmendationListClass;
    }

    /**
     * @param theRecommmendationListClass the theRecommmendationListClass to set
     */
    public void setTheRecommmendationListClass(RecommendationList theRecommmendationListClass) {
        this.theRecommmendationListClass = theRecommmendationListClass;
    }
}
