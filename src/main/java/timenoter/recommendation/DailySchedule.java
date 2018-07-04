/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timenoter.recommendation;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author fitexmage
 */
public class DailySchedule {
    
    private String name;
    private ArrayList<DailyEvent> dailyEventList;
    private Calendar createTime;
    
    public DailySchedule(String name, ArrayList<DailyEvent> dailyEventList, Calendar createTime){
        this.name = name;
        this.dailyEventList = dailyEventList;
        this.createTime = createTime;
    }
    
    public DailySchedule(){
        
    }
    
    public static DailySchedule newDailySchedule(String name, ArrayList<DailyEvent> dailyEventList){
        return new DailySchedule(name, dailyEventList, Calendar.getInstance());
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
     * @return the dailyEventList
     */
    public ArrayList<DailyEvent> getDailyEventList() {
        return dailyEventList;
    }

    /**
     * @param dailyEventList the dailyEventList to set
     */
    public void setDailyEventList(ArrayList<DailyEvent> dailyEventList) {
        this.dailyEventList = dailyEventList;
    }

    /**
     * @return the createTime
     */
    public Calendar getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(Calendar createTime) {
        this.createTime = createTime;
    }
}
