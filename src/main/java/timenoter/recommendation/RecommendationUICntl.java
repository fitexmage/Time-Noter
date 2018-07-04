/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timenoter.recommendation;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

/**
 *
 * @author fitexmage
 */
public class RecommendationUICntl implements Initializable {

    @FXML
    private Text currentSchedule;

    @FXML
    private TableView schedule;

    @FXML
    private TableColumn scheduleName;

    @FXML
    private TableColumn createTime;

    @FXML
    private TableColumn detail;

    @FXML
    private TableColumn use;
    
    @FXML
    private TableColumn delete;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        RecommendationCntl.getTheRecommendationCntl().initialize(currentSchedule, schedule, scheduleName, createTime, detail, use, delete);
    }

    @FXML
    private void createNew(ActionEvent event) {
        RecommendationCntl.getTheRecommendationCntl().createNew();
    }

    @FXML
    private void home(ActionEvent event) {
        RecommendationCntl.getTheRecommendationCntl().getNavCntl();
    }

    @FXML
    private void user(ActionEvent event) {
        RecommendationCntl.getTheRecommendationCntl().getUserCntl();
    }

    @FXML
    private void schedule(ActionEvent event) {
        RecommendationCntl.getTheRecommendationCntl().getScheduleCntl();
    }

    @FXML
    private void friend(ActionEvent event) {
        RecommendationCntl.getTheRecommendationCntl().getFriendCntl();
    }

    @FXML
    private void recommendation(ActionEvent event) {
        RecommendationCntl.getTheRecommendationCntl().getRecommendationCntl();
    }
}
