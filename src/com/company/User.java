package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private String userName;
    private String password;
    private ArrayList<BorrowedBook> myBorrowed;
    private boolean admin;

    public User(String userName, String password, boolean admin) {
        this.userName = userName;
        this.password = password;
        this.myBorrowed = new ArrayList();
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

    public void showMyBorrowed() {
        for (BorrowedBook myBooks : myBorrowed) {
            System.out.println(myBooks.getBorrowedBook().getTitle());
        }
    }

    @Override
    public String toString() {
        if (admin) {
            return userName + " (Admin)";
        }
        else {
            return userName;
        }
    }


    public static ArrayList<User> seedData()
    {
        ArrayList<User> users = new ArrayList();

        users.add(new User("John", "1234", true));
        users.add(new User("Smith", "1234", false));
        users.add(new User("Ali", "1234", false));
        users.add(new User("Gasem", "1234", false));
        users.add(new User("Mikool", "1234", false));

        return users;
    }
}
