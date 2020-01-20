package com.company;

import java.util.Date;

public class BorrowedBook {

    private Book borrowedBook ;
    private Date borrowedDate ;
    private Date returnDate ;
    private int maxBorrowingDays ;

    public BorrowedBook(Book borrowedBook, Date borrowedDate, Date returnDate, int borrowDays) {
        this.borrowedBook = borrowedBook;
        this.borrowedDate = borrowedDate;
        this.returnDate = returnDate;
        this.maxBorrowingDays = borrowDays;
    }
    public Book getBorrowedBook() {
        return borrowedBook;
    }

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public int getBorrowDays() {
        return maxBorrowingDays;
    }

    public void setBorrowedBook(Book borrowedBook) {
        this.borrowedBook = borrowedBook;
    }

    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public void setBorrowDays(int borrowDays) {
        this.maxBorrowingDays = borrowDays;
    }



}