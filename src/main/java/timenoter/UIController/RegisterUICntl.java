package timenoter.UIController;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import timenoter.controller.RegisterCntl;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.text.*;

/**
 *
 * @author fitexmage
 */
public class RegisterUICntl implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Text usernameAlert;
    @FXML
    private Text passwordAlert;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void confirm(ActionEvent event) {
        RegisterCntl.getTheRegisterCntl().addPlayer(username, password, usernameAlert, passwordAlert);
    }

    @FXML
    private void cancel(ActionEvent event) {
        RegisterCntl.getTheRegisterCntl().back();
    }
}
