package timenoter.login;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import timenoter.login.Account;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import timenoter.Data;
import timenoter.Message;

/**
 *
 * @author fitexmage
 */
public class RegisterCntl {

    private Stage theStage;
    private static RegisterCntl theRegisterCntl;

    public RegisterCntl(Stage theExistingStage) {
        theStage = theExistingStage;
    }

    public void setUpScene() {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/RegisterUI.fxml"));
            Scene scene = new Scene(root);
            theStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addPlayer(TextField username, TextField password, Text usernameAlert, Text passwordAlert) {
        boolean empty = false;
        boolean existed = false;
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
            if (Data.getTheData().getTheAccountListClass().getAccountList().isEmpty()) {
                int userID = 1;
                Data.getTheData().getTheAccountListClass().getAccountList().add(new Account(userID, username.getText(), password.getText()));
                Data.getTheData().getTheAccountListClass().writeFile();
                addNew(userID);
                Message.setMessage(theStage, "Register successfully!");
                LoginCntl.getTheLoginCntl().setUpScene();
            } else {
                if (Data.getTheData().getTheAccountListClass().isExisted(username.getText())) {
                    Message.setMessage(theStage, "Username already exists. Please try another one!");
                } else {
                    int userID = Data.getTheData().getTheAccountListClass().newUserID();
                    Data.getTheData().getTheAccountListClass().getAccountList().add(new Account(userID, username.getText(), password.getText()));
                    Data.getTheData().getTheAccountListClass().writeFile();
                    addNew(userID);
                    Message.setMessage(theStage, "Register successfully!");
                    LoginCntl.getTheLoginCntl().setUpScene();
                }
            }
        }
    }

    public void addNew(int userID) {
        Data.getTheData().getThePersonalInfoClass().addNew(userID);
        Data.getTheData().getThePersonalInfoClass().writeFile();
        Data.getTheData().getTheScheduleListClass().addNew(userID);
        Data.getTheData().getTheScheduleListClass().writeFile();
        Data.getTheData().getTheFriendListClass().addNew(userID);
        Data.getTheData().getTheFriendListClass().writeFile();
        Data.getTheData().getTheRecommmendationListClass().addNew(userID);
        Data.getTheData().getTheRecommmendationListClass().writeFile();
    }

    public void back() {
        LoginCntl.getTheLoginCntl().setUpScene();
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

    /**
     * @return the theRegisterCntl
     */
    public static RegisterCntl getTheRegisterCntl() {
        return theRegisterCntl;
    }

    public static RegisterCntl getTheRegisterCntl(Stage theStage) {
        theRegisterCntl = new RegisterCntl(theStage);
        return theRegisterCntl;
    }

    /**
     * @param aTheRegisterCntl the theRegisterCntl to set
     */
    public static void setTheRegisterCntl(RegisterCntl aTheRegisterCntl) {
        theRegisterCntl = aTheRegisterCntl;
    }
}
