/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timenoter.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author fitexmage
 */
public class PersonalInfoList {
    
    private ArrayList<PersonalInfo> personalInfoList;
    private String personalInfoFileName = "data/personalInfo.json";

    public PersonalInfoList() {
        personalInfoList = new ArrayList<PersonalInfo>();
        readFile();
    }

    public void readFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            personalInfoList = mapper.readValue(new File(personalInfoFileName), new TypeReference<ArrayList<PersonalInfo>>(){});
        } catch (IOException ex) {
            //ex.printStackTrace();
        }
    }

    public void writeFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(personalInfoFileName), personalInfoList);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void save(PersonalInfo newPersonalInfo) {
        PersonalInfo thePersonalInfo = getThePersonalInfo(newPersonalInfo.getUserID());
        thePersonalInfo.update(newPersonalInfo.getName(), newPersonalInfo.getEmail(), newPersonalInfo.getDescription());
        writeFile();
    }

    public void save() {
        PersonalInfo thePersonalInfo = getThePersonalInfo(User.getTheUser().getThePersonalInfo().getUserID());
        thePersonalInfo.update();
        writeFile();
    }

    public PersonalInfo getThePersonalInfo(int userID) {
        for (PersonalInfo thePersonalInfo : personalInfoList) {
            if (thePersonalInfo.getUserID() == userID) {
                return thePersonalInfo;
            }
        }
        return null;
    }

    public void addNew(int userID) {
        personalInfoList.add(new PersonalInfo(userID, Integer.toString(userID), "", ""));
    }

    /**
     * @return the personalInfoList
     */
    public ArrayList<PersonalInfo> getPersonalInfoList() {
        return personalInfoList;
    }

    /**
     * @param personalInfoList the personalInfoList to set
     */
    public void setPersonalInfoList(ArrayList<PersonalInfo> personalInfoList) {
        this.personalInfoList = personalInfoList;
    }

    /**
     * @return the personalInfoFileName
     */
    public String getPersonalInfoFileName() {
        return personalInfoFileName;
    }

    /**
     * @param personalInfoFileName the personalInfoFileName to set
     */
    public void setPersonalInfoFileName(String personalInfoFileName) {
        this.personalInfoFileName = personalInfoFileName;
    }
}
