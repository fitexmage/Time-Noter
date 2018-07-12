/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timenoter.controller;

import timenoter.model.Event;
import timenoter.controller.FriendCntl;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import timenoter.controller.NavCntl;
import timenoter.model.ObservableEvent;
import timenoter.model.User;
import timenoter.model.User;

/**
 *
 * @author fitexmage
 */
public class ScheduleCntl {

    private static ScheduleCntl theScheduleCntl;
    private Stage theStage;

    public ScheduleCntl(Stage theExistingStage) {
        theStage = theExistingStage;
    }

    public void setUpScene() {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/ScheduleUI.fxml"));
            Scene scene = new Scene(root);

            theStage.setTitle("Time Noter");
            theStage.setScene(scene);
            theStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initialize(TableView schedule, TableColumn eventName, TableColumn type, TableColumn startTime, TableColumn duration) {
        ObservableList<ObservableEvent> observableEventList = FXCollections.observableArrayList(User.getTheUser().getTheSchedule().observableEventList());
        schedule.setItems(observableEventList);
        eventName.setCellValueFactory(new PropertyValueFactory<Event, String>("eventName"));
        type.setCellValueFactory(new PropertyValueFactory<Event, String>("type"));
        startTime.setCellValueFactory(new PropertyValueFactory<Event, Date>("startTime"));
        duration.setCellValueFactory(new PropertyValueFactory<Event, String>("duration"));
    }

    public void getNavCntl() {
        NavCntl.getTheNavCntl(theStage).setUpScene();
    }

    public void getUserCntl() {
        UserCntl.getTheUserCntl(theStage).setUpScene();
    }

    public void getScheduleCntl() {
        ScheduleCntl.getTheScheduleCntl(theStage).setUpScene();
    }

    public void getFriendCntl() {
        FriendCntl.getTheFriendCntl(theStage).setUpScene();
    }

    public void getRecommendationCntl() {
        RecommendationCntl.getTheRecommendationCntl(theStage).setUpScene();
    }

    /**
     * @return the theScheduleCntl
     */
    public static ScheduleCntl getTheScheduleCntl() {
        return theScheduleCntl;
    }

    public static ScheduleCntl getTheScheduleCntl(Stage theStage) {
        theScheduleCntl = new ScheduleCntl(theStage);
        return theScheduleCntl;
    }

    /**
     * @param aTheScheduleCntl the theScheduleCntl to set
     */
    public static void setTheScheduleCntl(ScheduleCntl aTheScheduleCntl) {
        theScheduleCntl = aTheScheduleCntl;
    }

    /**
     * @return the theStage
     */
    public Stage getTheStage() {
        return theStage;
    }

    /**
     * @param theStage the theStage to set
     */
    public void setTheStage(Stage theStage) {
        this.theStage = theStage;
    }
}
