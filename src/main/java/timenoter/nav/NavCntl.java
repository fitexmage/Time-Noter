package timenoter.nav;

import timenoter.schedule.Event;
import timenoter.recommendation.DailySchedule;
import timenoter.recommendation.DailyEvent;
import timenoter.user.UserCntl;
import timenoter.schedule.ScheduleCntl;
import timenoter.recommendation.RecommendationCntl;
import timenoter.friend.FriendCntl;
import timenoter.login.ConfirmCntl;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import timenoter.Message;
import timenoter.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fitexmage
 */
public class NavCntl {

    private Stage theStage;
    private static NavCntl theNavCntl;

    Timer timer;
    public Timer recommendation;

    boolean timerStart = false;
    private Calendar startTime;
    private Calendar tempStartTime;
    private long duration = 0;
    private long tempDuration = 0;

    public NavCntl(Stage theExistingStage) {
        theStage = theExistingStage;
    }

    public void setUpScene() {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/NavUI.fxml"));
            Scene scene = new Scene(root);
            theStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initialize(ChoiceBox typeBox, TextField type, Text message) {
        ObservableList<String> typeList = FXCollections.observableArrayList(User.getTheUser().getTheSchedule().decsendingTypeList());
        typeBox.setItems(typeList);
        typeBox.getSelectionModel().select(0);
        type.setText(typeList.get(0));
        typeBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue ov,
                    Number value,
                    Number new_value) {
                type.setText(typeList.get(new_value.intValue()));
            }
        });
        
        recommendation = new Timer();
            recommendation.schedule(new TimerTask() {
                @Override
                public void run() {
                    DailySchedule theDailySchedule = User.getTheUser().getTheRecommendation().getCurrentSchedule();
                    LocalTime currentTime = LocalTime.now();
                    for(DailyEvent theDailyEvent: theDailySchedule.getDailyEventList()){
                        if(theDailyEvent.getHour() == currentTime.getHour()
                                && theDailyEvent.getMinute() == currentTime.getMinute()
                                && theDailyEvent.getSecond() == currentTime.getSecond()){
                            message.setText("Time for " + theDailyEvent.getType());
                        }
                    }
                }
            }, 0, 1000);
    }

    public void setNow(CheckBox now, DatePicker date, TextField startHour, TextField startMinute, TextField startSecond) {
        if (now.isSelected()) {
            date.setDisable(true);
            startHour.setDisable(true);
            startMinute.setDisable(true);
            startSecond.setDisable(true);
        } else {
            date.setDisable(false);
            startHour.setDisable(false);
            startMinute.setDisable(false);
            startSecond.setDisable(false);
        }
    }

    public void setTimer(Button timerBtn, DatePicker date, TextField startHour, TextField startMinute, TextField startSecond, TextField hour, TextField minute, TextField second) {

        if (timerStart == false) {
            timerBtn.setText("Stop");
            startTimer();
            LocalDate localDate = LocalDate.of(startTime.get(Calendar.YEAR), startTime.get(Calendar.MONTH) + 1, startTime.get(Calendar.DAY_OF_MONTH));
            date.setValue(localDate);
            startHour.setText(startTime.get(Calendar.HOUR_OF_DAY) + "");
            startMinute.setText(startTime.get(Calendar.MINUTE) + "");
            startSecond.setText(startTime.get(Calendar.SECOND) + "");

            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    tempDuration = User.getTheUser().getTheSchedule().durationInLong(tempStartTime, Calendar.getInstance());
                    LocalTime time = User.getTheUser().getTheSchedule().durationInLocalTime(duration + tempDuration);
                    hour.setText(time.getHour() + "");
                    minute.setText(time.getMinute() + "");
                    second.setText(time.getSecond() + "");
                }
            }, 0, 1000);
        } else {
            timerBtn.setText("Set timer");
            timer.cancel();
            duration += tempDuration;
            tempDuration = 0;
        }
        timerStart = !timerStart;
    }

    public void startTimer() {
        if (startTime == null) {
            startTime = Calendar.getInstance();
        }
        tempStartTime = Calendar.getInstance();
    }

    public void makeSchedule(TextField eventName, TextField type, DatePicker date, TextField startHour, TextField startMinute, TextField startSecond, CheckBox now, TextField hour, TextField minute, TextField second) {
        switch (isValid(eventName, type, date, startHour, startMinute, startSecond, now, hour, minute, second)) {
            case 1:
                Calendar startTime = Calendar.getInstance();
                if (!now.isSelected()) {
                    startTime.set(date.getValue().getYear(), date.getValue().getMonthValue() - 1, date.getValue().getDayOfMonth(), Integer.parseInt(startHour.getText()), Integer.parseInt(startMinute.getText()), Integer.parseInt(startSecond.getText()));
                }
                Long duration = User.getTheUser().getTheSchedule().durationInMillis(Integer.parseInt(hour.getText()), Integer.parseInt(minute.getText()), Integer.parseInt(second.getText()));
                Event newEvent = new Event(eventName.getText(), type.getText(), startTime, duration);

                ConfirmCntl.getTheConfirmCntl(theStage).setUpScene(newEvent);
                //System.out.println(newEvent.getEventName() + "\n" + newEvent.getType() + "\n" + newEvent.getStartTime().getTime() + "\n" + newEvent.endTime().getTime());
                break;
            case 2:
                Message.setMessage(theStage, "Input should not be empty!");
                break;
            case 3:
                Message.setMessage(theStage, "Time should be interger!");
                break;
            case 4:
                Message.setMessage(theStage, "Time is not valid!");
                break;
            case 5:
                Message.setMessage(theStage, "Time should be interger!");
                break;
            case 6:
                Message.setMessage(theStage, "Time is not valid!");
                break;
        }
    }

    public boolean isInt(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        String[] a = {"1", "2"};
        return pattern.matcher(str).matches();
    }

    public int isValid(TextField eventName, TextField type, DatePicker date, TextField startHour, TextField startMinute, TextField startSecond, CheckBox now, TextField hour, TextField minute, TextField second) {
        if (eventName.getText().isEmpty() || type.getText().isEmpty()
                || hour.getText().isEmpty() || minute.getText().isEmpty() || second.getText().isEmpty()) {
            return 2;
        } else if (!now.isSelected()) {
            if (date.getValue() == null || startHour.getText().isEmpty() || startMinute.getText().isEmpty() || startSecond.getText().isEmpty()) {
                return 2;
            } else {
                if (!isInt(startHour.getText()) || !isInt(startMinute.getText()) || !isInt(startSecond.getText())) {
                    return 3;
                } else if (Integer.parseInt(startHour.getText()) < 0 || Integer.parseInt(startHour.getText()) > 23
                        || Integer.parseInt(startMinute.getText()) < 0 || Integer.parseInt(startMinute.getText()) > 59
                        || Integer.parseInt(startSecond.getText()) < 0 || Integer.parseInt(startMinute.getText()) > 59) {
                    return 4;
                }
            }
        } else if (!isInt(hour.getText()) || !isInt(minute.getText()) || !isInt(second.getText())) {
            return 3;
        } else if (Integer.parseInt(hour.getText()) < 0
                || Integer.parseInt(minute.getText()) < 0 || Integer.parseInt(hour.getText()) > 59
                || Integer.parseInt(hour.getText()) < 0 || Integer.parseInt(hour.getText()) > 59) {
            return 4;
        }
        return 1;
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
     * @return the theNavCntl
     */
    public static NavCntl getTheNavCntl() {
        return theNavCntl;
    }

    public static NavCntl getTheNavCntl(Stage theStage) {
        theNavCntl = new NavCntl(theStage);
        return theNavCntl;
    }

    /**
     * @param aTheNavCntl the theNavCntl to set
     */
    public static void setTheNavCntl(NavCntl aTheNavCntl) {
        theNavCntl = aTheNavCntl;
    }
}
