/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timenoter.recommendation;

import java.util.ArrayList;
import timenoter.User;

/**
 *
 * @author fitexmage
 */
public class Recommendation {
    
    private int userID;
    private ArrayList<DailySchedule> dailyScheduleList;
    private DailySchedule currentSchedule;
    
    public Recommendation(int userID, ArrayList<DailySchedule> dailyScheduleList, DailySchedule currentSchedule){
        this.userID = userID;
        this.dailyScheduleList = dailyScheduleList;
        this.currentSchedule = currentSchedule;
    }
    
    public Recommendation(){
        
    }
    
    public void update(ArrayList<DailySchedule> dailyScheduleList, DailySchedule currentSchedule) {
        this.dailyScheduleList = dailyScheduleList;
        this.currentSchedule = currentSchedule;
    }

    public void update() {
        this.dailyScheduleList = User.getTheUser().getTheRecommendation().dailyScheduleList;
        this.currentSchedule = User.getTheUser().getTheRecommendation().currentSchedule;
    }
    
    public void addDefaultSchedule(){
        DailyEvent event1 = new DailyEvent("Eat", 7, 30, 0, 1800000L);
        DailyEvent event2 = new DailyEvent("Study", 10, 0, 0, 7200000L);
        DailyEvent event3 = new DailyEvent("Sleep", 21, 0, 0, 28800000L);
        ArrayList<DailyEvent> defaultDailyEventList = new ArrayList<DailyEvent>();
        defaultDailyEventList.add(event1);
        defaultDailyEventList.add(event2);
        defaultDailyEventList.add(event3);
        DailySchedule defaultDailySchedule = DailySchedule.newDailySchedule("Default Schedule", defaultDailyEventList);
        dailyScheduleList.add(defaultDailySchedule);
        dailyScheduleList.add(defaultDailySchedule);
        dailyScheduleList.add(defaultDailySchedule);
        this.currentSchedule = defaultDailySchedule;
    }
    
    public DailySchedule dailySchedule(String name){
        for(DailySchedule theDailySchedule: dailyScheduleList){
            if(theDailySchedule.getName().equals(name)){
                return theDailySchedule;
            }
        }
        return null;
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
     * @return the dailyScheduleList
     */
    public ArrayList<DailySchedule> getDailyScheduleList() {
        return dailyScheduleList;
    }

    /**
     * @param dailyScheduleList the dailyScheduleList to set
     */
    public void setDailyScheduleList(ArrayList<DailySchedule> dailyScheduleList) {
        this.dailyScheduleList = dailyScheduleList;
    }

    /**
     * @return the currentSchedule
     */
    public DailySchedule getCurrentSchedule() {
        return currentSchedule;
    }

    /**
     * @param currentSchedule the currentSchedule to set
     */
    public void setCurrentSchedule(DailySchedule currentSchedule) {
        this.currentSchedule = currentSchedule;
    }
}
