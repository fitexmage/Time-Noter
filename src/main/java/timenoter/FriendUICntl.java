/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timenoter;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 *
 * @author fitexmage
 */
public class FriendUICntl implements Initializable {

    @FXML
    private TableView friendList;

    @FXML
    private TableColumn friend;

    @FXML
    private TableColumn detail;

    @FXML
    private TableColumn remove;

    @FXML
    private TextField searchName;

    @FXML
    private GridPane friendDetail;

    @FXML
    private Text name;

    @FXML
    private Text email;

    @FXML
    private Text description;
    
    @FXML
    private GridPane recentEvent;
    
    @FXML
    private Text eventName;
    
    @FXML
    private Text startTime;
    
    @FXML
    private Text duration;
    
    @FXML
    private CheckBox share;

    @FXML
    private TableView requestList;

    @FXML
    private TableColumn request;

    @FXML
    private TableColumn accept;

    @FXML
    private TableColumn decline;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FriendCntl.getTheFriendCntl().initialize(friendList, friend, detail, remove, friendDetail, name, email, description, recentEvent, eventName, startTime, duration, share, requestList);
    }

    @FXML
    private void apply(ActionEvent event) {
        FriendCntl.getTheFriendCntl().apply(searchName);
    }
    
    @FXML
    private void request(ActionEvent event) {
        FriendCntl.getTheFriendCntl().request(requestList, request, accept, decline, friendDetail, recentEvent, share);
    }

    @FXML
    private void home(ActionEvent event) {
        FriendCntl.getTheFriendCntl().getNavCntl();
    }

    @FXML
    private void user(ActionEvent event) {
        FriendCntl.getTheFriendCntl().getUserCntl();
    }

    @FXML
    private void schedule(ActionEvent event) {
        FriendCntl.getTheFriendCntl().getScheduleCntl();
    }

    @FXML
    private void friend(ActionEvent event) {
        FriendCntl.getTheFriendCntl().getFriendCntl();
    }
    
    @FXML
    private void recommendation(ActionEvent event) {
        FriendCntl.getTheFriendCntl().getRecommendationCntl();
    }

}
