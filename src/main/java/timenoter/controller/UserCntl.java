/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timenoter.controller;

import timenoter.controller.ScheduleCntl;
import timenoter.controller.FriendCntl;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import timenoter.model.Data;
import timenoter.util.Message;
import timenoter.util.Message;
import timenoter.controller.NavCntl;
import timenoter.model.User;
import timenoter.model.User;

/**
 *
 * @author fitexmage
 */
public class UserCntl {

    private static UserCntl theUserCntl;
    private Stage theStage;

    public UserCntl(Stage theExistingStage) {
        theStage = theExistingStage;
    }

    public void setUpScene() {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/UserUI.fxml"));
            Scene scene = new Scene(root);

            theStage.setTitle("Time Noter");
            theStage.setScene(scene);
            theStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initialize(TextField username, TextField password, TextField name, TextField email, TextArea description) {
        username.setText(User.getTheUser().getTheAccount().getUsername());
        password.setText(User.getTheUser().getTheAccount().getPassword());
        name.setText(User.getTheUser().getThePersonalInfo().getName());
        email.setText(User.getTheUser().getThePersonalInfo().getEmail());
        description.setText(User.getTheUser().getThePersonalInfo().getDescription());
    }

    public void modify(TextField username, TextField password, TextField name, TextField email, TextArea description) {
        if (!username.getText().equals(User.getTheUser().getTheAccount().getUsername())
                && Data.getTheData().getTheAccountListClass().isExisted(username.getText())) {
            Message.setMessage(theStage, "Username already exists. Please try another one!");
        } else {
            User.getTheUser().getTheAccount().update(username.getText(), password.getText());
            User.getTheUser().getThePersonalInfo().update(name.getText(), email.getText(), description.getText());
            Message.setMessage(theStage, "Modify successfully!");
        }
    }

    public void getNavCntl() {
        NavCntl.getTheNavCntl(theStage).setUpScene();
    }

    public void getUserCntl() {
        UserCntl.getTheUserCntl(theStage).setUpScene();
    }

    public void getScheduleCntl() {
        ScheduleCntl.getTheScheduleCntl(theStage).setUpScene();
    }

    public void getFriendCntl() {
        FriendCntl.getTheFriendCntl(theStage).setUpScene();
    }

    public void getRecommendationCntl() {
        RecommendationCntl.getTheRecommendationCntl(theStage).setUpScene();
    }

    /**
     * @return the theUserCntl
     */
    public static UserCntl getTheUserCntl() {
        return theUserCntl;
    }

    public static UserCntl getTheUserCntl(Stage theStage) {
        theUserCntl = new UserCntl(theStage);
        return theUserCntl;
    }

    /**
     * @param aTheUserCntl the theUserCntl to set
     */
    public static void setTheUserCntl(UserCntl aTheUserCntl) {
        theUserCntl = aTheUserCntl;
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
