package com.company;

import java.util.Comparator;

public class SortBooksByTitle implements Comparator<Book> {

    @Override
    public int compare(Book t1, Book t2) {
        return t1.getTitle().compareToIgnoreCase(t2.getTitle());
    }
}
