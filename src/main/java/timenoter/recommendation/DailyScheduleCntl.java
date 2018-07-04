/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timenoter.recommendation;

import timenoter.user.UserCntl;
import timenoter.schedule.ScheduleCntl;
import timenoter.recommendation.RecommendationCntl;
import timenoter.friend.FriendCntl;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import timenoter.Message;
import timenoter.nav.NavCntl;
import timenoter.User;

/**
 *
 * @author fitexmage
 */
public class DailyScheduleCntl {

    private static DailyScheduleCntl theDailyScheduleCntl;
    private Stage theStage;

    private DailySchedule theDailySchedule;
    private int page = 0;

    public DailyScheduleCntl(Stage theExistingStage) {
        theStage = theExistingStage;
    }

    public void setUpScene(String name) {
        this.theDailySchedule = User.getTheUser().getTheRecommendation().dailySchedule(name);

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/DailyScheduleUI.fxml"));
            Scene scene = new Scene(root);

            theStage.setTitle("Time Noter");
            theStage.setScene(scene);
            theStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initialize(Pane namePage, TextField scheduleName, Pane schedulePage) {
        namePage.setVisible(true);
        scheduleName.setText(theDailySchedule.getName());
        schedulePage.setVisible(false);
    }

    public void confirmName(Pane namePage, TextField scheduleName, Pane schedulePage, TextField type, TextField startHour, TextField startMinute, TextField startSecond, TextField hour, TextField minute, TextField second) {
        if (scheduleName.getText().equals(theDailySchedule.getName())) {
            namePage.setVisible(false);
            schedulePage.setVisible(true);
            displayEvent(type, startHour, startMinute, startSecond, hour, minute, second);
            page = 0;
        } else if (User.getTheUser().getTheRecommendation().dailySchedule(scheduleName.getText()) == null) {
            User.getTheUser().getTheRecommendation().dailySchedule(theDailySchedule.getName()).setName(scheduleName.getText());
            namePage.setVisible(false);
            schedulePage.setVisible(true);
            displayEvent(type, startHour, startMinute, startSecond, hour, minute, second);
            page = 0;
        } else {
            Message.setMessage(theStage, "Schedule name already have!");
        }
    }

    public void previous(TextField type, TextField startHour, TextField startMinute, TextField startSecond, TextField hour, TextField minute, TextField second) {
        if (page == 0) {
            Message.setMessage(theStage, "It is the first one!");
        } else if (type.getText().equals("")
                || startHour.getText().equals("") || startMinute.getText().equals("") || startSecond.getText().equals("")
                || hour.getText().equals("") || minute.getText().equals("") || second.getText().equals("")) {
            Message.setMessage(theStage, "Input should not be empty!");
        } else {
            DailyEvent previousDailyEvent = theDailySchedule.getDailyEventList().get(page);
            previousDailyEvent.setType(type.getText());
            previousDailyEvent.setHour(Integer.parseInt(startHour.getText()));
            previousDailyEvent.setMinute(Integer.parseInt(startMinute.getText()));
            previousDailyEvent.setSecond(Integer.parseInt(startSecond.getText()));
            Long duration = previousDailyEvent.durationInMillis(Integer.parseInt(hour.getText()), Integer.parseInt(minute.getText()), Integer.parseInt(second.getText()));
            previousDailyEvent.setDuration(duration);

            page--;
            displayEvent(type, startHour, startMinute, startSecond, hour, minute, second);
        }
    }

    public void newEvent(TextField type, TextField startHour, TextField startMinute, TextField startSecond, TextField hour, TextField minute, TextField second) {
        theDailySchedule.getDailyEventList().add(new DailyEvent("", 0, 0, 0, 0L));
        page = theDailySchedule.getDailyEventList().size() - 1;
        displayEvent(type, startHour, startMinute, startSecond, hour, minute, second);
    }

    public void next(TextField type, TextField startHour, TextField startMinute, TextField startSecond, TextField hour, TextField minute, TextField second) {
        if (page == theDailySchedule.getDailyEventList().size() - 1) {
            Message.setMessage(theStage, "It is the last one!");
        } else if (type.getText().equals("")
                || startHour.getText().equals("") || startMinute.getText().equals("") || startSecond.getText().equals("")
                || hour.getText().equals("") || minute.getText().equals("") || second.getText().equals("")) {
            Message.setMessage(theStage, "Input should not be empty!");
        } else {
            DailyEvent previousDailyEvent = theDailySchedule.getDailyEventList().get(page);
            previousDailyEvent.setType(type.getText());
            previousDailyEvent.setHour(Integer.parseInt(startHour.getText()));
            previousDailyEvent.setMinute(Integer.parseInt(startMinute.getText()));
            previousDailyEvent.setSecond(Integer.parseInt(startSecond.getText()));
            Long duration = previousDailyEvent.durationInMillis(Integer.parseInt(hour.getText()), Integer.parseInt(minute.getText()), Integer.parseInt(second.getText()));
            previousDailyEvent.setDuration(duration);

            page++;
            displayEvent(type, startHour, startMinute, startSecond, hour, minute, second);
        }
    }

    public void displayEvent(TextField type, TextField startHour, TextField startMinute, TextField startSecond, TextField hour, TextField minute, TextField second) {
        DailyEvent theDailyEvent = theDailySchedule.getDailyEventList().get(page);
        type.setText(theDailyEvent.getType());
        startHour.setText(theDailyEvent.getHour() + "");
        startMinute.setText(theDailyEvent.getMinute() + "");
        startSecond.setText(theDailyEvent.getSecond() + "");
        hour.setText(theDailyEvent.durationInLocalTime(theDailyEvent.getDuration()).getHour() + "");
        minute.setText(theDailyEvent.durationInLocalTime(theDailyEvent.getDuration()).getMinute() + "");
        second.setText(theDailyEvent.durationInLocalTime(theDailyEvent.getDuration()).getSecond() + "");
    }

    public void confirm(TextField type, TextField startHour, TextField startMinute, TextField startSecond, TextField hour, TextField minute, TextField second) {
        DailyEvent theDailyEvent = theDailySchedule.getDailyEventList().get(page);
        theDailyEvent.setType(type.getText());
        theDailyEvent.setHour(Integer.parseInt(startHour.getText()));
        theDailyEvent.setMinute(Integer.parseInt(startMinute.getText()));
        theDailyEvent.setSecond(Integer.parseInt(startSecond.getText()));
        Long duration = theDailyEvent.durationInMillis(Integer.parseInt(hour.getText()), Integer.parseInt(minute.getText()), Integer.parseInt(second.getText()));
        theDailyEvent.setDuration(duration);
        
        if(theDailySchedule.getName().equals(User.getTheUser().getTheRecommendation().getCurrentSchedule().getName())){
            User.getTheUser().getTheRecommendation().setCurrentSchedule(theDailySchedule);
        }
        RecommendationCntl.getTheRecommendationCntl(theStage).setUpScene();
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
     * @return the theDailyScheduleCntl
     */
    public static DailyScheduleCntl getTheDailyScheduleCntl() {
        return theDailyScheduleCntl;
    }

    public static DailyScheduleCntl getTheDailyScheduleCntl(Stage theStage) {
        theDailyScheduleCntl = new DailyScheduleCntl(theStage);
        return theDailyScheduleCntl;
    }

    /**
     * @param aTheDailyScheduleCntl the theDailyScheduleCntl to set
     */
    public static void setTheDailyScheduleCntl(DailyScheduleCntl aTheDailyScheduleCntl) {
        theDailyScheduleCntl = aTheDailyScheduleCntl;
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
