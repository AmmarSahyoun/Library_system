package com.company;

public class Main {

    public static void main(String[] args) {
        boolean loginStatus = false;

        Program newProgram = new Program();
        newProgram.SetupLibrary();
        loginStatus = newProgram.Login();

        if (loginStatus == true) {
            newProgram.run();
        } else {
            System.out.println("Wrong username or password!!!");
        }

    }

}


