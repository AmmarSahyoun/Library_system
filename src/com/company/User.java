package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private String userName;
    private String password;
    private ArrayList<Book> myBorrowed;
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

    public ArrayList<Book> getMyBorrowed() {
        return myBorrowed;
    }

    public boolean isAdmin() {
        return admin;
    }

    public Book searchBookList(String phrase, BookFields bookFields) {
        Book resultBook = null;
        String searchPhrase = null;

        for (Book listBook : this.myBorrowed) {
            if (bookFields == BookFields.TITLE) {
                searchPhrase = listBook.getTitle();
            } else if (bookFields == BookFields.AUTHOR) {
                searchPhrase = listBook.getAuthor();
            } else if (bookFields == BookFields.DESCRIPTION) {
                searchPhrase = listBook.getDescription();
            }
            if (searchPhrase.equalsIgnoreCase((phrase))) {
                resultBook = listBook; //  Ref
                break;
            }
        }
        return resultBook;
    }

    @Override
    public String toString() {
        if (admin) {
            return userName + " (Admin)";
        } else {
            return userName;
        }
    }

    public void addBook(Book rentedBook) {
        myBorrowed.add(rentedBook);
    }

    public void removeBook(Book removedBook){
        myBorrowed.remove(removedBook);
    }

    public static ArrayList<User> seedData() {
        ArrayList<User> users = new ArrayList();

        users.add(new User("Johan", "1234", true));
        users.add(new User("James", "1234", false));
        users.add(new User("Ali", "1234", false));
        users.add(new User("Ammar", "1234", false));
        users.add(new User("Toni", "1234", false));

        return users;
    }
}
