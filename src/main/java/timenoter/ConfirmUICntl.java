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
import javafx.scene.text.Text;

/**
 *
 * @author fitexmage
 */
public class ConfirmUICntl implements Initializable {

    @FXML
    private Text eventName;
    @FXML
    private Text type;
    @FXML
    private Text startTime;
    @FXML
    private Text duration;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ConfirmCntl.getTheConfirmCntl().initialize(eventName, type, startTime, duration);
    }

    @FXML
    private void confirm(ActionEvent event) {
        ConfirmCntl.getTheConfirmCntl().confirm();
    }

    @FXML
    private void back(ActionEvent event) {
        ConfirmCntl.getTheConfirmCntl().back();
    }
}
