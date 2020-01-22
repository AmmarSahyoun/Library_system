package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Book implements Serializable {
    public BookCategory bookCategory;
    private String title;
    private String author;
    private String description;
    private boolean available;
    private Date borrowedDate ;
    private Date returnDate ;
    private int maxBorrowingDays = 14;


    public Book(BookCategory bookCategory, String title, String author, String description, boolean available, Date borrowedDate, Date returnDate, int maxBorrowingDays) {
        this.bookCategory = bookCategory;
        this.title = title;
        this.author = author;
        this.description = description;
        this.available = available;
        this.borrowedDate = borrowedDate;
        this.returnDate = returnDate;
        this.maxBorrowingDays = maxBorrowingDays;
    }


    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public void setMaxBorrowingDays(int maxBorrowingDays) {
        this.maxBorrowingDays = maxBorrowingDays;
    }


    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public int getMaxBorrowingDays() {
        return maxBorrowingDays;
    }


    @Override
    public String toString() {
        return  "\n=========================================" + "\nCategory: " + bookCategory +
                "\nTitle: " + title +
                "\nAuthor: " + author +
                "\nDescription: " + description +
                "\nAvailable: " + (available ? "Yes" : "No") + "\n==========================================";
    }


    public Book(BookCategory bookCategory, String title, String author, String description, boolean available) {
        this.bookCategory = bookCategory;
        this.title = title;
        this.author = author;
        this.description = description;
        this.available = available;
    }


    public BookCategory getBookCategory() {
        return bookCategory;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public boolean isAvailable() {
        return available;
    }


    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }


    public static ArrayList<Book> seedData() {
        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book(BookCategory.NOVEL, "you never can tell", "George shaw", "Act play about dentist who falls in love, and a family accidentally meet the father they have never known", true));
        books.add(new Book(BookCategory.HISTORY, "A Brief History of Humankind", "Yuval Harari", "From a renowned historian comes a groundbreaking narrative of humanity’s creation and evolution", true));
        books.add(new Book(BookCategory.BIOLOGY, "Biology of the Cell", "Bruce Alberts", "Act play about dentist who falls in love, and a family accidentally meet the father they have never known", true));
        books.add(new Book(BookCategory.SCIENCE, "The Science Book", "DK", "The Science Book explores how scientists have sought to explain our world and the universe, and how scientific discoveries have been made.", true));
        books.add(new Book(BookCategory.TECHNOLOGY, "Deep Learning", "Ian Goodfellow", "a resource intended to help students and practitioners enter the field of machine learning in general and deep learning in particular", true));
        books.add(new Book(BookCategory.SPORTS, "A Life", "Jonathan Eig", "The definitive biography of an American icon, from aNew York Timesbest-selling author with unique access to Ali’s inner circle", true));
        books.add(new Book(BookCategory.SPORTS, "FEVER PITCH", "William Hill", "Hornby has put his finger on truths that have been unspoken for generations.", true));
        books.add(new Book(BookCategory.TECHNOLOGY, "Artificial Intelligence", "John Buyers", "The book provides a grounding of what differentiates artificially intelligent systems from traditional technology and explains the differences between AI, ML and DL ", true));
        books.add(new Book(BookCategory.HISTORY, "Say Nothing", "Patrick Keefe", "A masterful history of the Troubles. . . Extraordinary. . .As in the most ingenious crime stories, Keefe unveils a revelation", true));
        books.add(new Book(BookCategory.TECHNOLOGY, "Hackers", "Steven Levy", "The book traces the exploits of the computer revolution's original hackers -- those brilliant and eccentric ", true));

        return books;
    }
}
