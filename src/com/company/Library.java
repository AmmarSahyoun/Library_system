package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Library {

    private User loggedUser = null; // current user that will borrow books
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    public Library(ArrayList<Book> definedBooks, ArrayList<User> definedUsers) { // ?? when we use list in constructor
        this.books = definedBooks;
        this.users = definedUsers;
    }

    public boolean Login(String Username, String Password) {
        boolean result = false;

        for (User thisUser : users) {
            if (thisUser.getUserName().equalsIgnoreCase(Username)
                    && thisUser.getPassword().equals(Password)) {
                result = true;
                loggedUser = thisUser;
                break;
            }
        }
        return result;
    }

    public boolean isAdmin() {
        return loggedUser.isAdmin();
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

    // Sajeh
    public int getIndexOf(Book book) {
        return books.indexOf(book.getTitle());
    }

    public ArrayList<Book> showBooksList() {
        for (Book book : books) {
            System.out.println("Book name: " + book.getTitle() + ", Category: " + book.bookCategory);
        }
        return books;
    }

    public String showBookInfo(String title) {
        for (Book booKInfo : books) {
            if (title.equalsIgnoreCase(booKInfo.getTitle())) {
                return booKInfo.toString();
            }
        }
        return null;
    }

    public ArrayList<Book> borrowBook(String title) {
        for (Book borrowBook : books) {
            if (title.equalsIgnoreCase(borrowBook.getTitle())) {
                if (borrowBook.isAvailable()) {
                    borrowBook.setAvailable(false);
                    borrowBook.setBorrowedDate(new Date());
                    borrowBook.setReturnDate(null);

                    // loggedUser.addBook(borrowedRemoved);


                    return null;
                } else System.out.println("book is already borrowed!");
            }
            return null;
        }
        return null;
    }

    public String searchBookByTitle(String title) {
        for (Book book : books) {
            if (title.equalsIgnoreCase(book.getTitle())) {
                return book.toString();
            }
        }
        return null;
    }

    public String searchBookByAuthor(String title) {
        for (Book book : books) {
            if (title.equalsIgnoreCase(book.getAuthor())) {
                return book.toString();
            }
        }
        return null;
    }

    public ArrayList<Book> borrowBookIndefinitely() {
        return null;
    }

    public ArrayList<Book> showMyBorrowedBooks() {
        return null;
    }

    public ArrayList<Book> showAvailableBooks() {
        return null;
    }

    public ArrayList<String> orderBookByTitle() {
        return null;
    }

    public String showBookReturnTime() {
        return null;
    }

}

