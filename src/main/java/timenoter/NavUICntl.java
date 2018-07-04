package timenoter;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fitexmage
 */
public class NavUICntl implements Initializable {

    @FXML
    private TextField eventName;
    @FXML
    private TextField type;
    @FXML
    private ChoiceBox typeBox;
    @FXML
    private DatePicker date;
    @FXML
    private TextField startHour;
    @FXML
    private TextField startMinute;
    @FXML
    private TextField startSecond;
    @FXML
    private CheckBox now;
    @FXML
    private TextField hour;
    @FXML
    private TextField minute;
    @FXML
    private TextField second;
    @FXML
    private Button timerBtn;
    @FXML
    private Text message;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        NavCntl.getTheNavCntl().initialize(typeBox, type, message);
    }
    
    @FXML
    private void setNow(ActionEvent event) {
        NavCntl.getTheNavCntl().setNow(now, date, startHour, startMinute, startSecond);
    }

    @FXML
    private void setTimer(ActionEvent event) {
        NavCntl.getTheNavCntl().setTimer(timerBtn, date, startHour, startMinute, startSecond, hour, minute, second);
    }

    @FXML
    private void makeSchedule(ActionEvent event) {
        NavCntl.getTheNavCntl().makeSchedule(eventName, type, date, startHour, startMinute, startSecond, now, hour, minute, second);
    }

    @FXML
    private void home(ActionEvent event) {
        NavCntl.getTheNavCntl().getNavCntl();
    }

    @FXML
    private void user(ActionEvent event) {
        NavCntl.getTheNavCntl().getUserCntl();
    }

    @FXML
    private void schedule(ActionEvent event) {
        NavCntl.getTheNavCntl().getScheduleCntl();
    }

    @FXML
    private void friend(ActionEvent event) {
        NavCntl.getTheNavCntl().getFriendCntl();
    }

    @FXML
    private void recommendation(ActionEvent event) {
        NavCntl.getTheNavCntl().getRecommendationCntl();
    }
}
