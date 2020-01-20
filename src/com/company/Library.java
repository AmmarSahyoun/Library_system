package com.company;

import java.util.ArrayList;

public class Library {

    private User logedUser = null; // current user that will borrow books
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    public Library() {
    }

    public Library(ArrayList<Book> definedBooks, ArrayList<User> definedUsers) {
        this.books = definedBooks;
        this.users = definedUsers ;
    }

    public boolean Login(String Username, String Password)
    {
        boolean result = false;

        for (User thisUser : users)
        {
            if (thisUser.getUserName().equalsIgnoreCase(Username)
                    && thisUser.getPassword().equals(Password))
            {
                result = true;
                logedUser = thisUser;
                break;
            }

        }

        return result;
    }

    public boolean isAdmin()
    {
        return logedUser.isAdmin();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void addBook(Book book, User user) {
        if (user.isAdmin() == true) {
            books.add(book);
        } else {
            System.out.println("\n Only Librarian add books!");
        }
    }

    public void addUser(User user) {
        users.add(user);
    }


}
