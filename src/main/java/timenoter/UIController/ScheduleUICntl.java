/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timenoter.UIController;

import timenoter.controller.ScheduleCntl;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * @author fitexmage
 */
public class ScheduleUICntl implements Initializable {

    @FXML
    private TableView schedule;

    @FXML
    private TableColumn eventName;

    @FXML
    private TableColumn type;

    @FXML
    private TableColumn startTime;
    
    @FXML
    private TableColumn duration;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ScheduleCntl.getTheScheduleCntl().initialize(schedule, eventName, type, startTime, duration);
    }

    @FXML
    private void home(ActionEvent event) {
        ScheduleCntl.getTheScheduleCntl().getNavCntl();
    }

    @FXML
    private void user(ActionEvent event) {
        ScheduleCntl.getTheScheduleCntl().getUserCntl();
    }

    @FXML
    private void schedule(ActionEvent event) {
        ScheduleCntl.getTheScheduleCntl().getScheduleCntl();
    }

    @FXML
    private void friend(ActionEvent event) {
        ScheduleCntl.getTheScheduleCntl().getFriendCntl();
    }

    @FXML
    private void recommendation(ActionEvent event) {
        ScheduleCntl.getTheScheduleCntl().getRecommendationCntl();
    }
}
