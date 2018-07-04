/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timenoter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author fitexmage
 */
public class FriendCntl {

    private static FriendCntl theFriendCntl;
    private Stage theStage;

    public FriendCntl(Stage theExistingStage) {
        theStage = theExistingStage;
    }

    public void setUpScene() {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/FriendUI.fxml"));
            Scene scene = new Scene(root);

            theStage.setTitle("Time Noter");
            theStage.setScene(scene);
            theStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initialize(TableView friendList, TableColumn friend, TableColumn detail, TableColumn remove, GridPane friendDetail, Text name, Text email, Text description, GridPane recentEvent, Text eventName, Text startTime, Text duration, CheckBox share, TableView requestList) {
        ArrayList<ObservableFriend> observableFriendList = new ArrayList<ObservableFriend>();
        for (Entry<Integer, Integer> theFriend : User.getTheUser().getTheFriend().getFriendIDList().entrySet()) {
            Button detailButton = new Button("Enter");
            detailButton.setOnAction((ActionEvent e) -> {
                friendDetail.setVisible(true);
                PersonalInfo friendPersonalInfo = Data.getTheData().getThePersonalInfoClass().getThePersonalInfo(theFriend.getKey());
                name.setText(friendPersonalInfo.getName());
                email.setText(friendPersonalInfo.getEmail());
                description.setText(friendPersonalInfo.getDescription());
                HashMap<Integer, Integer> friendFriendIDList = Data.getTheData().getTheFriendListClass().getTheFriend(theFriend.getKey()).getFriendIDList();
                for (Entry<Integer, Integer> theUser : friendFriendIDList.entrySet()) {
                    if (theUser.getKey() == User.getTheUser().getTheAccount().getUserID()) {
                        if (theUser.getValue() == 1) {
                            ArrayList<ObservableEvent> eventList = Data.getTheData().getTheScheduleListClass().getTheSchedule(theFriend.getKey()).observableEventList();
                            if (!eventList.isEmpty()) {
                                recentEvent.setVisible(true);
                                ObservableEvent friendObservableEvent = eventList.get(eventList.size() - 1);
                                eventName.setText(friendObservableEvent.getEventName());
                                startTime.setText(friendObservableEvent.getStartTime() + "");
                                duration.setText(friendObservableEvent.getDuration());
                            }
                        } else {
                            recentEvent.setVisible(false);
                        }
                    }
                }
                share.setVisible(true);
                if (theFriend.getValue() == 1) {
                    share.setSelected(true);
                } else {
                    share.setSelected(false);
                }
                share.setOnAction((ActionEvent event) -> {
                    for (Entry<Integer, Integer> theUser : User.getTheUser().getTheFriend().getFriendIDList().entrySet()) {
                        if (theUser.getKey() == theFriend.getKey()) {
                            if (share.isSelected()) {
                                User.getTheUser().getTheFriend().getFriendIDList().replace(theUser.getKey(), 1);
                            } else {
                                User.getTheUser().getTheFriend().getFriendIDList().replace(theUser.getKey(), 0);
                            }
                        }
                    }
                    if (share.isSelected()) {
                        User.getTheUser().getTheFriend().getFriendIDList().replace(theFriend.getKey(), 1);
                    } else {
                        User.getTheUser().getTheFriend().getFriendIDList().replace(theFriend.getKey(), 0);
                    }
                });
                requestList.setVisible(false);
            });

            Button removeButton = new Button("Remove");
            removeButton.setOnAction((ActionEvent e) -> {
                User.getTheUser().getTheFriend().getFriendIDList().remove((Object) theFriend.getKey());
                Data.getTheData().getTheFriendListClass().getTheFriend(theFriend.getKey()).getFriendIDList().remove((Object) User.getTheUser().getTheAccount().getUserID());
                setUpScene();
            });
            ObservableFriend theFriendTable = new ObservableFriend(Data.getTheData().getThePersonalInfoClass().getThePersonalInfo(theFriend.getKey()).getName(), detailButton, removeButton);
            observableFriendList.add(theFriendTable);
        }
        ObservableList<ObservableFriend> observableFriendTableList = FXCollections.observableArrayList(observableFriendList);
        friendList.setItems(observableFriendTableList);
        friend.setCellValueFactory(new PropertyValueFactory<Event, String>("name"));
        detail.setCellValueFactory(new PropertyValueFactory<Event, Button>("operation1"));
        remove.setCellValueFactory(new PropertyValueFactory<Event, Button>("operation2"));
    }

    public void apply(TextField searchName) {
        boolean isUser = false;
        boolean isFriend = false;
        boolean inRequest = false;
        String message = "";
        if (searchName.getText().equals(User.getTheUser().getTheAccount().getUsername())) {
            message = "You cannot add yourself!";
        } else {
            for (Account theAccount : Data.getTheData().getTheAccountListClass().getAccountList()) {
                if (theAccount.getUsername().equals(searchName.getText())) {
                    isUser = true;
                    for (Entry<Integer, Integer> theFriend : Data.getTheData().getTheFriendListClass().getTheFriend(User.getTheUser().getTheAccount().getUserID()).getFriendIDList().entrySet()) {
                        if (theFriend.getKey() == theAccount.getUserID()) {
                            isFriend = true;
                            message = theAccount.getUsername() + " is already your friend!";
                        }
                    }

                    for (int requestId : Data.getTheData().getTheFriendListClass().getTheFriend(theAccount.getUserID()).getRequestIDList()) {
                        if (requestId == User.getTheUser().getTheAccount().getUserID()) {
                            System.out.println("A");
                            inRequest = true;
                            message = "You have already sent the request!";
                        }
                    }

                    for (int requestId : Data.getTheData().getTheFriendListClass().getTheFriend(User.getTheUser().getTheAccount().getUserID()).getRequestIDList()) {
                        if (requestId == theAccount.getUserID()) {
                            inRequest = true;
                            message =  theAccount.getUsername() + " has requested to become your friend, try accept in the request list!";
                        }
                    }
                    
                    if (isFriend == false && inRequest == false) {
                        Data.getTheData().getTheFriendListClass().getTheFriend(theAccount.getUserID()).getRequestIDList().add(User.getTheUser().getTheAccount().getUserID());
                        message = "Apply successfully!";
                    }
                }
            }
            if (isUser == false) {
                message = "Username does not exist!";
            }
        }
        Message.setMessage(theStage, message);
    }

    public void request(TableView requestList, TableColumn request, TableColumn accept, TableColumn decline, GridPane friendDetail, GridPane recentEvent, CheckBox share) {
        System.out.println("A");
        requestList.setVisible(true);
        friendDetail.setVisible(false);
        recentEvent.setVisible(false);
        share.setVisible(false);
        ArrayList<ObservableFriend> observableRequestList = new ArrayList<ObservableFriend>();

        for (int requestID : User.getTheUser().getTheFriend().getRequestIDList()) {
            Button acceptButton = new Button("Accept");
            acceptButton.setOnAction((ActionEvent e) -> {
                User.getTheUser().getTheFriend().getFriendIDList().put(requestID, 0);
                Data.getTheData().getTheFriendListClass().getTheFriend(requestID).getFriendIDList().put(User.getTheUser().getTheAccount().getUserID(), 0);
                User.getTheUser().getTheFriend().getRequestIDList().remove((Object) requestID);
                setUpScene();
            });

            Button declineButton = new Button("Decline");
            declineButton.setOnAction((ActionEvent e) -> {
                User.getTheUser().getTheFriend().getRequestIDList().remove((Object) requestID);
                setUpScene();
            });
            ObservableFriend theRequestTable = new ObservableFriend(Data.getTheData().getThePersonalInfoClass().getThePersonalInfo(requestID).getName(), acceptButton, declineButton);
            observableRequestList.add(theRequestTable);
        }
        ObservableList<ObservableFriend> observableRequestTableList = FXCollections.observableArrayList(observableRequestList);
        requestList.setItems(observableRequestTableList);
        request.setCellValueFactory(new PropertyValueFactory<Event, String>("name"));
        accept.setCellValueFactory(new PropertyValueFactory<Event, Button>("operation1"));
        decline.setCellValueFactory(new PropertyValueFactory<Event, Button>("operation2"));
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
     * @return the theFriendCntl
     */
    public static FriendCntl getTheFriendCntl() {
        return theFriendCntl;
    }

    public static FriendCntl getTheFriendCntl(Stage theStage) {
        theFriendCntl = new FriendCntl(theStage);
        return theFriendCntl;
    }

    /**
     * @param aTheFriendCntl the theFriendCntl to set
     */
    public static void setTheFriendCntl(FriendCntl aTheFriendCntl) {
        theFriendCntl = aTheFriendCntl;
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
