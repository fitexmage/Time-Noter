/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timenoter.UIController;

import timenoter.controller.DailyScheduleCntl;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 *
 * @author fitexmage
 */
public class DailyScheduleUICntl implements Initializable {

    @FXML
    private Pane namePage;

    @FXML
    private TextField scheduleName;

    @FXML
    private Pane schedulePage;

    @FXML
    private TextField type;

    @FXML
    private TextField startHour;

    @FXML
    private TextField startMinute;

    @FXML
    private TextField startSecond;

    @FXML
    private TextField hour;

    @FXML
    private TextField minute;

    @FXML
    private TextField second;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DailyScheduleCntl.getTheDailyScheduleCntl().initialize(namePage, scheduleName, schedulePage);
    }

    @FXML
    private void confirmName(ActionEvent event) {
        DailyScheduleCntl.getTheDailyScheduleCntl().confirmName(namePage, scheduleName, schedulePage, type, startHour, startMinute, startSecond, hour, minute, second);
    }

    @FXML
    private void previous(ActionEvent event) {
        DailyScheduleCntl.getTheDailyScheduleCntl().previous(type, startHour, startMinute, startSecond, hour, minute, second);
    }

    @FXML
    private void newEvent(ActionEvent event) {
        DailyScheduleCntl.getTheDailyScheduleCntl().newEvent(type, startHour, startMinute, startSecond, hour, minute, second);
    }

    @FXML
    private void next(ActionEvent event) {
        DailyScheduleCntl.getTheDailyScheduleCntl().next(type, startHour, startMinute, startSecond, hour, minute, second);
    }

    @FXML
    private void confirm(ActionEvent event) {
        DailyScheduleCntl.getTheDailyScheduleCntl().confirm(type, startHour, startMinute, startSecond, hour, minute, second);
    }

    @FXML
    private void home(ActionEvent event) {
        DailyScheduleCntl.getTheDailyScheduleCntl().getNavCntl();
    }

    @FXML
    private void user(ActionEvent event) {
        DailyScheduleCntl.getTheDailyScheduleCntl().getUserCntl();
    }

    @FXML
    private void schedule(ActionEvent event) {
        DailyScheduleCntl.getTheDailyScheduleCntl().getScheduleCntl();
    }

    @FXML
    private void friend(ActionEvent event) {
        DailyScheduleCntl.getTheDailyScheduleCntl().getFriendCntl();
    }

    @FXML
    private void recommendation(ActionEvent event) {
        DailyScheduleCntl.getTheDailyScheduleCntl().getRecommendationCntl();
    }
}
