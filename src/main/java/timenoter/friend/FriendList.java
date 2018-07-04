package timenoter.friend;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
public class FriendList {

    private ArrayList<Friend> friendList;
    private String friendFileName = "data/friend.json";

    public FriendList() {
        friendList = new ArrayList<Friend>();
        readFile();
    }

    public void readFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            friendList = mapper.readValue(new File(friendFileName), new TypeReference<ArrayList<Friend>>() {
            });
        } catch (IOException ex) {
            //ex.printStackTrace();
        }
    }

    public void writeFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(friendFileName), friendList);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void save(Friend newFriend) {
        Friend theFriend = getTheFriend(newFriend.getUserID());
        theFriend.update(newFriend.getFriendIDList(), newFriend.getRequestIDList());
        writeFile();
    }

    public void save() {
        Friend theFriend = getTheFriend(User.getTheUser().getTheFriend().getUserID());
        theFriend.update();
        writeFile();
    }

    public Friend getTheFriend(int userID) {
        for (Friend theFriend : friendList) {
            if (theFriend.getUserID() == userID) {
                return theFriend;
            }
        }
        return null;
    }

    public void addNew(int userID) {
        
        HashMap<Integer, Integer> friendIDList = new HashMap<Integer, Integer>();
        ArrayList<Integer> requestFriendIDList = new ArrayList<Integer>();
        friendList.add(new Friend(userID, friendIDList, requestFriendIDList));
    }
}
