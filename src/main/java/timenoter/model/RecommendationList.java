/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timenoter.model;

import timenoter.model.DailySchedule;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author fitexmage
 */
public class RecommendationList {
    
    private ArrayList<Recommendation> recommendationList;
    private String recommendationFileName = "data/recommendation.json";

    public RecommendationList() {
        recommendationList = new ArrayList<Recommendation>();
        readFile();
    }

    public void readFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            recommendationList = mapper.readValue(new File(recommendationFileName), new TypeReference<ArrayList<Recommendation>>() {
            });
        } catch (IOException ex) {
            //ex.printStackTrace();
        }
    }

    public void writeFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(recommendationFileName), recommendationList);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void save(Recommendation newRecommendation) {
        Recommendation theRecommendation = getTheRecommendation(newRecommendation.getUserID());
        theRecommendation.update(newRecommendation.getDailyScheduleList(), newRecommendation.getCurrentSchedule());
        writeFile();
    }

    public void save() {
        Recommendation theRecommendation = getTheRecommendation(User.getTheUser().getTheRecommendation().getUserID());
        theRecommendation.update();
        writeFile();
    }

    public Recommendation getTheRecommendation(int userID) {
        for (Recommendation theRecommendation : recommendationList) {
            if (theRecommendation.getUserID() == userID) {
                return theRecommendation;
            }
        }
        return null;
    }

    public void addNew(int userID) {
        ArrayList<DailySchedule> dailyScheduleList = new ArrayList<DailySchedule>();
        Recommendation newRecommendation = new Recommendation(userID, dailyScheduleList, null);
        newRecommendation.addDefaultSchedule();
        recommendationList.add(newRecommendation);
    }
}
