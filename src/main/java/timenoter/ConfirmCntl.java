/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timenoter;

import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author fitexmage
 */
public class ConfirmCntl {

    private static ConfirmCntl theConfirmCntl;
    private Stage theStage;

    private Event newEvent;

    public ConfirmCntl(Stage theExistingStage) {
        theStage = theExistingStage;
    }

    public void setUpScene(Event newEvent) {

        try {
            this.newEvent = newEvent;
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/ConfirmUI.fxml"));
            Scene scene = new Scene(root);

            theStage.setTitle("Time Noter");
            theStage.setScene(scene);
            theStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initialize(Text eventName, Text type, Text startTime, Text duration) {
        eventName.setText(newEvent.getEventName());
        type.setText(newEvent.getType());
        startTime.setText(newEvent.getStartTime().getTime() + "");
        ArrayList<Long> durationList = newEvent.durationInHMS();
        duration.setText(durationList.get(0) + " h " + durationList.get(1) + " m " + durationList.get(2) + " s");
    }

    public void confirm() {
        Message.setMessage(theStage, "Create successfully!");
        User.getTheUser().getTheSchedule().getEventList().add(newEvent);
        User.getTheUser().getTheSchedule().addType(newEvent.getType());
        NavCntl.getTheNavCntl().setUpScene();
    }

    public void back() {
        NavCntl.getTheNavCntl().setUpScene();
    }

    /**
     * @return the theConfirmCntl
     */
    public static ConfirmCntl getTheConfirmCntl() {
        return theConfirmCntl;
    }

    public static ConfirmCntl getTheConfirmCntl(Stage theStage) {
        theConfirmCntl = new ConfirmCntl(theStage);
        return theConfirmCntl;
    }

    /**
     * @param aTheConfirmCntl the theConfirmCntl to set
     */
    public static void setTheConfirmCntl(ConfirmCntl aTheConfirmCntl) {
        theConfirmCntl = aTheConfirmCntl;
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
