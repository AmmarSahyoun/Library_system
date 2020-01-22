package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    // Files constance
    public int choice;
    Scanner scn = new Scanner(System.in);


    public Program() {
    }

    public void SetupLibrary() {
        // Program Start Here.
        ObjectSerializer fileObject;
        ArrayList<Book> savedBooks = null;
        ArrayList<User> savedUsers = null;

        // Create file loader for books
        fileObject = new ObjectSerializer(BOOKS_FILE);
        // Check if books file exists
        File dataFile = new File(BOOKS_FILE);
        if (dataFile.exists()) {
            // Load from dat file
            savedBooks = (ArrayList<Book>) fileObject.ReadObjectFromFile();
        } else {
            // Create new array from seeds
            savedBooks = Book.seedData();
            // Create the dat file
            fileObject.WriteObjectToFile(savedBooks);
        }

        // Check if Users exists
        fileObject = new ObjectSerializer(USERS_FILE);
        dataFile = new File(USERS_FILE);

        if (dataFile.exists()) {
            // Load Users from the file
            savedUsers = (ArrayList<User>) fileObject.ReadObjectFromFile();
        } else {
            // create new array from seeds
            savedUsers = User.seedData();
            // write it to dat file
            fileObject.WriteObjectToFile(savedUsers);
        }

        // Create Library
        this.nationalLibrary = new Library(savedBooks, savedUsers);
    }

    public boolean Login() {
        // 1- Display welcome screen, ask to login
        System.out.println("\n     .:Welcome to the Library Login:. ");
        System.out.println("Please Enter your username:  ");
        String inpUser = scn.nextLine();

        System.out.println("Enter your Password: ");
        String inpPass = scn.nextLine();

        boolean loginStatus = false;
        loginStatus = nationalLibrary.Login(inpUser, inpPass);
        return loginStatus;

    }

    public void run() {
        boolean startUserMenu = true;

        while (startUserMenu) {

            System.out.println();
            System.out.println("    .:Welcome to the Library:.");
            System.out.println("[1] Show all books "); // Done
            System.out.println("[2] Show book info"); // Done
            System.out.println("[3] Borrow a book");
            System.out.println("[4] find a book by title"); // Done
            System.out.println("[5] find a book by author"); // Done
            System.out.println("[6] Borrow book indefinitely");
            System.out.println("[7] Show my borrowed books");
            System.out.println("[8] return a borrowed book");
            System.out.println("[9] Show available books to borrow");
            System.out.println("[10] Order the books by title"); //Done
            System.out.println("[11] see how much time left to return a book");
            if (nationalLibrary.isAdmin()) {
                System.out.println("[12] Show all borrowed Books");
                System.out.println("[13] add new book");
                System.out.println("[14] remove book");
                System.out.println("[15] Show a list of all users");
                System.out.println("[16] Search for a user with Name");
                System.out.println("[17] Show user's borrowed books");
                System.out.println("[18] show a users borrowed books"); //by name
            }
            System.out.println("[0] Exit");
            try {
                choice = Integer.parseInt(scn.nextLine());
            } catch (NumberFormatException ex) {
                System.err.println("Choose a valid number");
            } catch (Exception e) {
                System.out.println("Not a valid number");
            }

            if (choice == 1) {
                showBooksList();
            }
            if (choice == 2) {
                showBookInfo();
            }
            if (choice == 3) {
                borrowBook();
            }
            if (choice == 4) {
                searchBookByTitle();
            }
            if (choice == 5) {
                searchBookAuthor();
            }
            if (choice == 6) {
                borrowBookIndefinitely();
            }
            if (choice == 7) {
                showMyBorrowedBooks();
            }
            if (choice > 8) {
                returnBorrowedBook();
            }
            if (choice == 9) {
                showAvailableBooks();
            }
            if (choice == 10) {
                sortByTitle();
            }
            if (choice == 11) {
                showBookReturnTime();
            }
            if (choice == 12) {
                ;
            }
            if (choice == 13) {
                addNewBook();
            }
            if (choice == 14) {
                ;
            }
            if (choice == 15) {
                ;
            }
            if (choice > 16) {
                ;
            }
            if (choice == 17) {
                ;
            }
            if (choice == 18) {
                ;
            }
            if (choice == 0) {
                break;
            }
        }
        System.out.print("Thank you and Goodbye..");
    }


    private void showBooksList() {
        nationalLibrary.showBooksList();
    }

    private void showBookInfo() {
        System.out.print("Enter a book title to show info: ");
        String bookTitle = scn.nextLine();
        System.out.println(nationalLibrary.showBookInfo(bookTitle));
    }

    private void borrowBook() {
        System.out.println("Enter a book title to borrow: ");
        String bookToBorrow = scn.nextLine();
        System.out.println("Done " + nationalLibrary.borrowBook(bookToBorrow));
    }

    private void searchBookByTitle() {
        System.out.println("Enter a book title to find: ");
        String titleToFind = scn.nextLine();
        System.out.println("Found:" + nationalLibrary.searchBookByTitle(titleToFind));
    }

    private void searchBookAuthor() {
        System.out.println("Enter a book author to find: ");
        String authorToFind = scn.nextLine();
        System.out.println("Found:" + nationalLibrary.searchBookByAuthor(authorToFind));
    }

    private void borrowBookIndefinitely() {
      /*  public boolean borrowHolding(){
            if(status == true && isOnLoan() == false)
                borrowDate = newDateTime(); //this is to get the time when the book or video is borrowed

            return true;
        }else
        return false; }

    */

    }

    private void showMyBorrowedBooks() {
        nationalLibrary.showMyBorrowedBooks();
    }

    private void returnBorrowedBook() {

    }

    private void showAvailableBooks() {

    }

    private void orderBookByTitle() {

    }

    private void showBookReturnTime() {

    }

    private void sortByTitle() {
        nationalLibrary.getBooks().sort((t1, t2) -> {
            return t1.getTitle().compareTo(t2.getTitle());
        });
        for (Book book : nationalLibrary.getBooks()) {
            System.out.printf("Title: %s, category: %s, Available %b\n", book.getTitle(), book.getBookCategory(), book.isAvailable());
            System.out.println("...................................................................");
        }
    }

    public void addNewBook() {

        if (!nationalLibrary.isAdmin()) {
            System.out.println("you are not allowed to add books!");
            return;
        }

        System.out.print("choose a category: 1.History 2.Biology 3.Novel 4.Science 5.Technology 6.Sports ");
        Scanner scanCat = new Scanner(System.in);
        int category = scanCat.nextInt();

        System.out.print("Enter the book title: ");
        Scanner scan = new Scanner(System.in);
        String title = scan.nextLine();

        System.out.print("Enter the book author: ");
        Scanner scanner = new Scanner(System.in);
        String author = scanner.nextLine();

        System.out.println("Enter the book's short description: ");
        Scanner scanners = new Scanner(System.in);
        String description = scanners.nextLine();

        nationalLibrary.getBooks().add(new Book(BookCategory.values()[category -1], title, author, description, true));

        System.out.println("    ..You have added new Book successfully!..");


    }
}

