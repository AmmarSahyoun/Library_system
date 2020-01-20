package com.company;

public class Main {

    public static void main(String[] args) {


        Program newProgram = new Program();
        newProgram.SetupLibrary();
        if (newProgram.Login() == true) {
            newProgram.run();
        }



        /*
        // Note 1 : Write User array to file
            ArrayList<User> myUsers = User.seedData();
            ObjectSerializer objectIO = new ObjectSerializer("./Users.dat");
            objectIO.WriteObjectToFile(myUsers);
        */

        /*

        // Note 2 : Read User list from File
        ArrayList<User> savedUser ;
        ObjectSerializer objectIO = new ObjectSerializer("./Users.dat");
        savedUser = (ArrayList<User>)objectIO.ReadObjectFromFile();

        for(User thisUser : savedUser)
        {
            System.out.println(thisUser);
        }

        */

        /*
        // Note 3: Write the book array list to a file
        ArrayList<Book> books = Book.seedData();
        ObjectSerializer recorder = new ObjectSerializer("./Books.dat");
        recorder.WriteObjectToFile(books);
        */





   }

}


