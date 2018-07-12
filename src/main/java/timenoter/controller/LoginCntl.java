package timenoter.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import timenoter.model.Account;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import timenoter.model.Data;
import timenoter.util.Message;
import timenoter.util.Message;
import timenoter.model.User;
import timenoter.model.User;

/**
 *
 * @author fitexmage
 */
public class LoginCntl {

    private static LoginCntl theLoginCntl;
    private Stage theStage;

    public LoginCntl(Stage theExistingStage) {
        theStage = theExistingStage;
    }

    public void setUpScene() {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/LoginUI.fxml"));
            Scene scene = new Scene(root);

            theStage.setTitle("Time Noter");
            theStage.setScene(scene);
            theStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void authenticate(TextField username, TextField password, Text usernameAlert, Text passwordAlert) {

        boolean empty = false;
        boolean authenticated = false;
        usernameAlert.setText("");
        passwordAlert.setText("");

        if (username.getText().isEmpty()) {
            usernameAlert.setText("Please enter your username!");
            empty = true;
        }
        if (password.getText().isEmpty()) {
            passwordAlert.setText("Please enter your password!");
            empty = true;
        }

        if (empty == false) {
            for (Account theAccount : Data.getTheData().getTheAccountListClass().getAccountList()) {
                if (theAccount.getUsername().equals(username.getText()) && theAccount.getPassword().equals(password.getText())) {
                    authenticated = true;
                    if (Data.getTheData().getTheScheduleListClass().getTheSchedule(theAccount.getUserID()) == null) {
                        Data.getTheData().getTheScheduleListClass().addNew(theAccount.getUserID());
                    }
                    User.setTheUser(new User(theAccount.getUserID()));
                    NavCntl.getTheNavCntl(theStage).setUpScene();
                }
            }
            if (authenticated == false) {
                Message.setMessage(theStage, "Username and password do not match. Please try again!");
            }
        }
    }

    public void getRegisterCntl() {
        RegisterCntl.getTheRegisterCntl(theStage).setUpScene();
    }

    /**
     * @return the theLoginCntl
     */
    public static LoginCntl getTheLoginCntl() {
        return theLoginCntl;
    }

    public static LoginCntl getTheLoginCntl(Stage theStage) {
        theLoginCntl = new LoginCntl(theStage);
        return theLoginCntl;
    }

    /**
     * @param aTheLoginCntl the theLoginCntl to set
     */
    public static void setTheLoginCntl(LoginCntl aTheLoginCntl) {
        theLoginCntl = aTheLoginCntl;
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
}
