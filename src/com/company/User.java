package com.company;

import java.util.ArrayList;

public class User {
    private String userName;
    private String password;
    private ArrayList<BorrowedBook> myBorrowed;
    private boolean admin;

    public User(String userName, String password, boolean admin) {
        this.userName = userName;
        this.password = password;
        this.myBorrowed = myBorrowed;
        this.admin = admin;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<BorrowedBook> getMyBorrowed() {
        return myBorrowed;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMyBorrowed(ArrayList<BorrowedBook> myBorrowed) {
        this.myBorrowed = myBorrowed;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public BorrowedBook showMyBorrowed() {
        for (BorrowedBook myBooks : myBorrowed) {
            return myBooks;
        }
        return null;
    }

}
