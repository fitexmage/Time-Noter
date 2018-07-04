package timenoter;

import java.util.ArrayList;
import java.util.Calendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fitexmage
 */
public class Event {

    private String eventName;
    private String type;
    private Calendar startTime;
    private Long duration;

    public Event(String eventName, String type, Calendar startTime, Long duration) {
        this.eventName = eventName;
        this.type = type;
        this.startTime = startTime;
        this.duration = duration;
    }

    public Event() {

    }

    public Calendar endTime() {
        long time = startTime.getTime().getTime() + duration;
        Calendar endTime = Calendar.getInstance();
        endTime.setTimeInMillis(time);
        return endTime;
    }

    public ArrayList<Long> durationInHMS() {
        ArrayList<Long> durationList = new ArrayList<Long>();
        long hour = duration / 1000 / 60 / 60;
        long minute = duration / 1000 / 60 - hour * 60;
        long second = duration / 1000 - hour * 60 * 60 - minute * 60;
        durationList.add(hour);
        durationList.add(minute);
        durationList.add(second);
        return durationList;
    }
    
    public String durationInString(){
        String durationString = "";
        long hour = duration / 1000 / 60 / 60;
        long minute = duration / 1000 / 60 - hour * 60;
        long second = duration / 1000 - hour * 60 * 60 - minute * 60;
        durationString = hour + " h " + minute + " m " + second + " s";
        return durationString;
    }

    /**
     * @return the eventName
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * @param eventName the eventName to set
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the startTime
     */
    public Calendar getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the duration
     */
    public Long getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(Long duration) {
        this.duration = duration;
    }
}
