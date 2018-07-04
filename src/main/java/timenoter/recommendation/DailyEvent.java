/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timenoter.recommendation;

import java.time.LocalTime;

/**
 *
 * @author fitexmage
 */
public class DailyEvent {

    private String type;
    private int hour;
    private int minute;
    private int second;
    private Long duration;

    public DailyEvent(String type, int hour, int minute, int second, Long duration) {
        this.type = type;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.duration = duration;
    }

    public DailyEvent() {

    }

    public LocalTime durationInLocalTime(long duration) {
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
     * @return the hour
     */
    public int getHour() {
        return hour;
    }

    /**
     * @param hour the hour to set
     */
    public void setHour(int hour) {
        this.hour = hour;
    }

    /**
     * @return the minute
     */
    public int getMinute() {
        return minute;
    }

    /**
     * @param minute the minute to set
     */
    public void setMinute(int minute) {
        this.minute = minute;
    }

    /**
     * @return the second
     */
    public int getSecond() {
        return second;
    }

    /**
     * @param second the second to set
     */
    public void setSecond(int second) {
        this.second = second;
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
