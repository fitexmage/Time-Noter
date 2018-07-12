package timenoter.UIController;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import timenoter.controller.LoginCntl;
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
public class LoginUICntl implements Initializable {

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
    private void login(ActionEvent event) {
        LoginCntl.getTheLoginCntl().authenticate(username, password, usernameAlert, passwordAlert);
    }

    @FXML
    private void signUp(ActionEvent event) {
        LoginCntl.getTheLoginCntl().getRegisterCntl();
    }
}
