package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    private Library nationalLibrary = null;

    public Program()
    {
    }

    public void SetupLibrary(){
        // Program Start Here.
        // Create new instance from serialization class to read books file
        ObjectSerializer fileObject = new ObjectSerializer("./Books.dat");
        // Load books from the file
        ArrayList<Book> savedBooks = (ArrayList<Book>)fileObject.ReadObjectFromFile();

        // Create another new instance on the same object from serialization class to read users file
        fileObject = new ObjectSerializer("./Users.dat");
        // Load Users from the file
        ArrayList<User> savedUsers = (ArrayList<User>)fileObject.ReadObjectFromFile();

        // Create Library
        this.nationalLibrary = new Library(savedBooks, savedUsers);
    }

    public boolean Login()
    {
        // 1- Display welcome screen, ask to login
        Scanner scan = null;

        Scanner keyboard = new Scanner(System.in);
        System.out.println("\n     .:Welcome to the Library:. ");
        System.out.println("Please Enter your username:  ");
        String inpUser = keyboard.nextLine();

        System.out.println("Enter your Password: ");
        String inpPass = keyboard.nextLine();

        return nationalLibrary.Login(inpUser, inpPass);
    }

    public void run()
    {
        if (nationalLibrary.isAdmin())
        {
            AdminMenu adminMenu = new AdminMenu();
            adminMenu.setupAdminMenu();
            adminMenu.runAdmin();
        }
        else
        {
            UserMenu newMenu = new UserMenu();
            newMenu.setupUserMenu();
            newMenu.runUser();
        }
    }



}