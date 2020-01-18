package com.company;

public class Book {
    public BookCategory bookCategory ;
    private String title ;
    private String author ;
    private String description ;
    private boolean available ;

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

}
