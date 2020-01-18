package com.company;

public class Program {

    public Program(){
        User user1 = new User("Ammar","1231231",true);
        User user2 = new User("Johan","123456",false);
        User user3 = new User("Anna","123456",false);
        User user4 = new User("Tony","123456",false);

        Book book1 = new Book(BookCategory.NOVEL,"you never can tell","George shaw","Act play about dentist who falls in love, and a family accidentally meet the father they have never known", true);
        Book book2 = new Book(BookCategory.HISTORY,"A Brief History of Humankind","Yuval Harari","From a renowned historian comes a groundbreaking narrative of humanity’s creation and evolution", true);
        Book book3 = new Book(BookCategory.BIOLOGY,"Biology of the Cell","Bruce Alberts","Act play about dentist who falls in love, and a family accidentally meet the father they have never known", true);
        Book book4 = new Book(BookCategory.SCIENCE,"The Science Book","DK","The Science Book explores how scientists have sought to explain our world and the universe, and how scientific discoveries have been made.", true);
        Book book5 = new Book(BookCategory.TECHNOLOGY,"Deep Learning","Ian Goodfellow","a resource intended to help students and practitioners enter the field of machine learning in general and deep learning in particular", true);
        Book book6 = new Book(BookCategory.SPORTS,"A Life","Jonathan Eig","The definitive biography of an American icon, from aNew York Timesbest-selling author with unique access to Ali’s inner circle", true);
        Book book7 = new Book(BookCategory.SPORTS,"FEVER PITCH","William Hill","Hornby has put his finger on truths that have been unspoken for generations.", true);
        Book book8 = new Book(BookCategory.TECHNOLOGY,"Artificial Intelligence","John Buyers","The book provides a grounding of what differentiates artificially intelligent systems from traditional technology and explains the differences between AI, ML and DL ", true);
        Book book9 = new Book(BookCategory.HISTORY,"Say Nothing","Patrick Keefe","A masterful history of the Troubles. . . Extraordinary. . .As in the most ingenious crime stories, Keefe unveils a revelation", true);
        Book book10 = new Book(BookCategory.TECHNOLOGY,"Hackers","Steven Levy","The book traces the exploits of the computer revolution's original hackers -- those brilliant and eccentric ", true);
    }



}
