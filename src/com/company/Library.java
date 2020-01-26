package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Library {

    private User loggedUser = null;
    private ArrayList<Book> books;
    private ArrayList<User> users;

    public Library(ArrayList<Book> definedBooks, ArrayList<User> definedUsers) {
        this.books = definedBooks;
        this.users = definedUsers;
    }

    public boolean login(String Username, String Password) {
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

    public void showAllBooks(String available) {
        for (Book book : books) {
            if (available != null) {

                boolean availableStatus = Boolean.parseBoolean(available);
                if (book.isAvailable() != availableStatus) {
                    continue;
                }
            }
            System.out.println("Book name: " + book.getTitle() + ", Category: " + book.bookCategory);
        }
    }

    public String showBookInfo(String title) {
        for (Book booKInfo : books) {
            if (title.equalsIgnoreCase(booKInfo.getTitle())) {
                return booKInfo.toString();
            }
        }
        return "WE DO NOT HAVE THIS BOOK";
    }

    public Book searchBookList(String phrase, BookFields bookFields) {
        Book resultBook = null;
        String searchPhrase = null;

        for (Book listBook : books) {
            if (bookFields == BookFields.TITLE) {
                searchPhrase = listBook.getTitle();
            } else if (bookFields == BookFields.AUTHOR) {
                searchPhrase = listBook.getAuthor();
            } else if (bookFields == BookFields.DESCRIPTION) {
                searchPhrase = listBook.getDescription();
            }
            if (searchPhrase.equalsIgnoreCase((phrase))) {
                resultBook = listBook;
                break;
            }
        }
        return resultBook;
    }

    public Book borrowBook(String title, boolean Indefinitely) {
        Book bookToBorrow = searchBookList(title, BookFields.TITLE);

        if (bookToBorrow == null || !bookToBorrow.isAvailable()) {
            return null;
        }
        Book rentedBook = bookToBorrow.borrowThisBook(loggedUser.getUserName(), 14, Indefinitely);
        loggedUser.addBook(rentedBook);
        return bookToBorrow;
    }

    public Book returnBorrowedBook(String title) {
        Book bookToReturn = loggedUser.searchBookList(title, BookFields.TITLE);
        Book originalBook = searchBookList(title, BookFields.TITLE);

        if (bookToReturn == null || originalBook == null) {
            return null;
        }

        originalBook.setAvailable(true);
        originalBook.setReturnDate(new Date());
        loggedUser.removeBook(bookToReturn);
        return bookToReturn;
    }

    public String findBookByTitle(String title) {
        try {
            return searchBookList(title, BookFields.TITLE).toString();
        } catch (Exception e) {
            return "enter a valid BOOK TITLE";
        }
    }

    public String findBookByAuthor(String author) {
        try {
            return searchBookList(author, BookFields.AUTHOR).toString();
        } catch (Exception e) {
            return "sorry we don't have any book for this author NAME!";
        }
    }

    public ArrayList<Book> showMyBorrowedBooks() {
        return loggedUser.getMyBorrowed();
    }

    public String removeBook(String title) {
        books.removeIf(booK -> title.equalsIgnoreCase(booK.getTitle()));
        return "done";
    }

    public void showAllUsers() {
        for (User user : users) {
            System.out.println("User: " + user.toString());
        }
    }

    public void allUsersBorrowedBooks() {
        for (User user : users) {
            if (user.getMyBorrowed().size() > 0) {
                System.out.println("User: " + user.toString());

                for (Book exitingBook : user.getMyBorrowed()) {
                    System.out.println("Book: " + exitingBook.getTitle());
                }  System.out.println("----------------------------");
            }
        }
    }

    public User searchUserByName(String userName) {
        User foundUser = null;
        for (User user : users) {
            if (user.getUserName().equalsIgnoreCase(userName)) {
                System.out.println("found: " + user);
            }

        }
        return foundUser;
    }

    public void userBorrowedBooks(String userName) {
        for (User user : users) {
            if (user.getUserName().equalsIgnoreCase(userName) && user.getMyBorrowed().size() > 0) {
                System.out.println("User: " + user.toString());
                System.out.println("----------------------------");
                for (Book exitingBook : user.getMyBorrowed()) {
                    System.out.println("Book: " + exitingBook.getTitle());
                }
                return;
            }
        }

        System.out.println("No books found for this user!");
    }
}

