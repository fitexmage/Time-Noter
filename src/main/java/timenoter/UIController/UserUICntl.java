/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timenoter.UIController;

import timenoter.controller.UserCntl;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author fitexmage
 */
public class UserUICntl implements Initializable {

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private TextField name;

    @FXML
    private TextField email;

    @FXML
    private TextArea description;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UserCntl.getTheUserCntl().initialize(username, password, name, email, description);
    }

    @FXML
    private void modify(ActionEvent event) {
        UserCntl.getTheUserCntl().modify(username, password, name, email, description);
    }

    @FXML
    private void home(ActionEvent event) {
        UserCntl.getTheUserCntl().getNavCntl();
    }

    @FXML
    private void user(ActionEvent event) {
        UserCntl.getTheUserCntl().getUserCntl();
    }

    @FXML
    private void schedule(ActionEvent event) {
        UserCntl.getTheUserCntl().getScheduleCntl();
    }

    @FXML
    private void friend(ActionEvent event) {
        UserCntl.getTheUserCntl().getFriendCntl();
    }

    @FXML
    private void recommendation(ActionEvent event) {
        UserCntl.getTheUserCntl().getRecommendationCntl();
    }
}
