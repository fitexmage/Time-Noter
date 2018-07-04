/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timenoter.recommendation;

import timenoter.friend.FriendCntl;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import timenoter.schedule.Event;
import timenoter.nav.NavCntl;
import timenoter.schedule.ScheduleCntl;
import timenoter.User;
import timenoter.user.UserCntl;

/**
 *
 * @author fitexmage
 */
public class RecommendationCntl {

    private Stage theStage;
    private static RecommendationCntl theRecommendationCntl;

    public RecommendationCntl(Stage theExistingStage) {
        theStage = theExistingStage;
    }

    public void setUpScene() {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/RecommendationUI.fxml"));
            Scene scene = new Scene(root);

            theStage.setTitle("Time Noter");
            theStage.setScene(scene);
            theStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initialize(Text currentSchedule, TableView schedule, TableColumn scheduleName, TableColumn createTime, TableColumn detail, TableColumn use, TableColumn delete) {
        currentSchedule.setText(User.getTheUser().getTheRecommendation().getCurrentSchedule().getName());

        ArrayList<ObservableDailySchedule> observableDailyScheduleList = new ArrayList<ObservableDailySchedule>();
        for (DailySchedule theDailySchedule : User.getTheUser().getTheRecommendation().getDailyScheduleList()) {
            Button detailButton = new Button("Enter");
            detailButton.setOnAction((ActionEvent e) -> {
                DailyScheduleCntl.getTheDailyScheduleCntl(theStage).setUpScene(theDailySchedule.getName());
            });

            Button useButton = new Button("Use");
            useButton.setOnAction((ActionEvent e) -> {
                User.getTheUser().getTheRecommendation().setCurrentSchedule(theDailySchedule);
                RecommendationCntl.getTheRecommendationCntl().setUpScene();
            });

            Button deleteButton = new Button("Delete");
            deleteButton.setOnAction((ActionEvent e) -> {
                User.getTheUser().getTheRecommendation().getDailyScheduleList().remove((DailySchedule) theDailySchedule);
                RecommendationCntl.getTheRecommendationCntl().setUpScene();
            });

            ObservableDailySchedule theObservableDailySchedule = new ObservableDailySchedule(theDailySchedule.getName(), theDailySchedule.getCreateTime().getTime(), detailButton, useButton, deleteButton);
            observableDailyScheduleList.add(theObservableDailySchedule);
        }

        ObservableList<ObservableDailySchedule> observableDailyScheduleTableList = FXCollections.observableArrayList(observableDailyScheduleList);
        schedule.setItems(observableDailyScheduleTableList);
        scheduleName.setCellValueFactory(new PropertyValueFactory<Event, String>("scheduleName"));
        createTime.setCellValueFactory(new PropertyValueFactory<Event, String>("createTime"));
        detail.setCellValueFactory(new PropertyValueFactory<Event, Button>("detailButton"));
        use.setCellValueFactory(new PropertyValueFactory<Event, Button>("useButton"));
        delete.setCellValueFactory(new PropertyValueFactory<Event, Button>("deleteButton"));
    }

    public void createNew() {
        ArrayList<DailyEvent> dailyEventList = new ArrayList<DailyEvent>();
        DailyEvent newDailyEvent = new DailyEvent("", 0, 0, 0, 0L);
        dailyEventList.add(newDailyEvent);
        DailySchedule newDailySchedule = DailySchedule.newDailySchedule("New Event", dailyEventList);
        User.getTheUser().getTheRecommendation().getDailyScheduleList().add(newDailySchedule);
        DailyScheduleCntl.getTheDailyScheduleCntl(theStage).setUpScene(newDailySchedule.getName());
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

    /**
     * @return the theRecommendationCntl
     */
    public static RecommendationCntl getTheRecommendationCntl() {
        return theRecommendationCntl;
    }

    public static RecommendationCntl getTheRecommendationCntl(Stage theStage) {
        theRecommendationCntl = new RecommendationCntl(theStage);
        return theRecommendationCntl;
    }

    /**
     * @param aTheRecommendationCntl the theRecommendationCntl to set
     */
    public static void setTheRecommendationCntl(RecommendationCntl aTheRecommendationCntl) {
        theRecommendationCntl = aTheRecommendationCntl;
    }

}
