package com.company;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;
    private ArrayList<User> users;

    public Library(ArrayList<Book> books, ArrayList<User> users) {
        this.books = books;
        this.users = users;
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
