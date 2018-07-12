package timenoter.model;

import timenoter.model.Event;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fitexmage
 */
public class Schedule implements Serializable {

    private int userID;
    private ArrayList<Event> eventList;
    private HashMap<String, Integer> typeMap;

    public Schedule(int userID, ArrayList<Event> eventList, HashMap<String, Integer> typeMap) {
        this.userID = userID;
        this.eventList = eventList;
        this.typeMap = typeMap;
    }

    public Schedule() {

    }

    public void addDefaultType() {
        typeMap.put("Sleep", 0);
        typeMap.put("Eat", 0);
        typeMap.put("Work", 0);
    }

    public void update(ArrayList<Event> eventList, HashMap<String, Integer> typeMap) {
        this.eventList = eventList;
        this.typeMap = typeMap;
    }

    public void update() {
        this.eventList = User.getTheUser().getTheSchedule().eventList;
        this.typeMap = User.getTheUser().getTheSchedule().typeMap;
    }

    public void addType(String type) {
        if (typeMap.containsKey(type)) {
            typeMap.replace(type, typeMap.get(type) + 1);
        } else {
            typeMap.put(type, 1);
        }
    }

    public ArrayList<String> decsendingTypeList() {
        ArrayList<String> acsendingTypeList = new ArrayList<String>();
        int typeNum = 0;
        List<Map.Entry<String, Integer>> typeList = new ArrayList<Map.Entry<String, Integer>>(typeMap.entrySet());
        Collections.sort(typeList, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for (Map.Entry<String, Integer> mapping : typeList) {
            if (typeNum < 5) {
                acsendingTypeList.add(mapping.getKey());
            }
            typeNum++;
        }
        return acsendingTypeList;
    }

    public long durationInLong(Calendar startTime, Calendar endTime) {
        long duration = endTime.getTime().getTime() - startTime.getTime().getTime();
        return duration;
    }
    
    public LocalTime durationInLocalTime(long duration){
        long hour = duration / 1000 / 60 / 60;
        long minute = duration / 1000 / 60 - hour * 60;
        long second = duration / 1000 - hour * 60 * 60 - minute * 60;
        LocalTime time = LocalTime.of((int) hour, (int) minute, (int) second, 0);
        return time;
    }

    public Long durationInMillis(int hour, int minute, int second) {
        Long hourToMillis = hour * 60 * 60 * 1000L;
        Long minuteToMillis = minute * 60 * 1000L;
        Long secondToMillis = second * 1000L;
        return hourToMillis + minuteToMillis + secondToMillis;
    }

    public ArrayList<ObservableEvent> observableEventList() {
        ArrayList<ObservableEvent> observableEventList = new ArrayList<ObservableEvent>();
        for (Event theEvent : eventList) {
            observableEventList.add(new ObservableEvent(theEvent.getEventName(), theEvent.getType(), theEvent.getStartTime().getTime(), theEvent.durationInString()));
        }
        return observableEventList;
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
     * @return the eventList
     */
    public ArrayList<Event> getEventList() {
        return eventList;
    }

    /**
     * @param eventList the eventList to set
     */
    public void setEventList(ArrayList<Event> eventList) {
        this.eventList = eventList;
    }

    /**
     * @return the typeMap
     */
    public HashMap<String, Integer> getTypeMap() {
        return typeMap;
    }

    /**
     * @param typeMap the typeMap to set
     */
    public void setTypeMap(HashMap<String, Integer> typeMap) {
        this.typeMap = typeMap;
    }
}
