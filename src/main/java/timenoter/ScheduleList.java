package timenoter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
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
public class ScheduleList {

    private ArrayList<Schedule> scheduleList;
    private String scheduleFileName = "data/schedule.json";

    public ScheduleList() {
        scheduleList = new ArrayList<Schedule>();
        readFile();
    }

    public void readFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            scheduleList = mapper.readValue(new File(scheduleFileName), new TypeReference<ArrayList<Schedule>>() {
            });
        } catch (IOException ex) {
            //ex.printStackTrace();
        }
    }

    public void writeFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(scheduleFileName), scheduleList);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void save(Schedule newSchedule) {
        Schedule theSchedule = getTheSchedule(newSchedule.getUserID());
        theSchedule.update(newSchedule.getEventList(), newSchedule.getTypeMap());
        writeFile();
    }

    public void save() {
        Schedule theSchedule = getTheSchedule(User.getTheUser().getTheAccount().getUserID());
        theSchedule.update();
        writeFile();
    }

    public Schedule getTheSchedule(int userID) {
        for (Schedule theSchedule : scheduleList) {
            if (theSchedule.getUserID() == userID) {
                return theSchedule;
            }
        }
        return null;
    }

    public void addNew(int usedID) {
        ArrayList<Event> eventList = new ArrayList<Event>();
        HashMap<String, Integer> typeList = new HashMap<String, Integer>();
        Schedule newSchedule = new Schedule(usedID, eventList, typeList);
        newSchedule.addDefaultType();
        scheduleList.add(newSchedule);
    }
}
