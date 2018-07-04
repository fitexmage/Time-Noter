package timenoter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fitexmage
 */
public class AccountList {

    private ArrayList<Account> accountList;
    private String accountFileName = "data/account.json";

    public AccountList() {
        accountList = new ArrayList<Account>();
        readFile();
    }

    public void readFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            accountList = mapper.readValue(new File(accountFileName), new TypeReference<ArrayList<Account>>() {
            });
        } catch (IOException ex) {
            //ex.printStackTrace();
        }
    }

    public void writeFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(accountFileName), accountList);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void save(Account newAccount) {
        Account theAccount = getTheAccount(newAccount.getUserID());
        theAccount.update(newAccount.getUsername(), newAccount.getPassword());
        writeFile();
    }

    public void save() {
        Account theAccount = getTheAccount(User.getTheUser().getTheAccount().getUserID());
        theAccount.update();
        writeFile();
    }

    public Account getTheAccount(int userID) {
        for (Account theAccount : accountList) {
            if (theAccount.getUserID() == userID) {
                return theAccount;
            }
        }
        return null;
    }

    public void addNew(String newUsername, String newPassWord) {
        accountList.add(new Account(newUserID(), newUsername, newPassWord));
    }

    public int newUserID() {
        return getHighest() + 1;
    }

    public boolean isExisted(String username) {
        for (Account theAccount : accountList) {
            if (theAccount.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public int getHighest() {
        int highest = 0;
        for (Account theAccount : accountList) {
            if (highest < theAccount.getUserID()) {
                highest = theAccount.getUserID();
            }
        }
        return highest;
    }

    /**
     * @return the accountList
     */
    public ArrayList<Account> getAccountList() {
        return accountList;
    }

    /**
     * @param accountList the accountList to set
     */
    public void setAccountList(ArrayList<Account> accountList) {
        this.accountList = accountList;
    }
}
