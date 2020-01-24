package com.company;

import java.io.File;
import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Program {

    private Library nationalLibrary = null;
    private final String BOOKS_FILE = "./Books.dat";
    private final String USERS_FILE = "./Users.dat";
    public int choice;
    Scanner scn = new Scanner(System.in);

    public Program() {
    }

    public void run() {
        boolean startUserMenu = true;

        while (startUserMenu) {

            System.out.println();
            System.out.println("    .:Welcome to the Library:.");
            System.out.println("[1] Show all books ");
            System.out.println("[2] Show book info");
            System.out.println("[3] Borrow a book");
            System.out.println("[4] find a book by title");
            System.out.println("[5] find a book by author");
            System.out.println("[6] Borrow book indefinitely");
            System.out.println("[7] Show my borrowed books");
            System.out.println("[8] return a borrowed book");
            System.out.println("[9] Show available books to borrow");
            System.out.println("[10] Order the books by title");
            System.out.println("[11] see how much time left to return a book");
            if (nationalLibrary.isAdmin()) {
                System.out.println("[12] Show all borrowed Books");
                System.out.println("[13] add new book");
                System.out.println("[14] remove book");
                System.out.println("[15] Show a list of all users");
                System.out.println("[16] Search for a user with Name");
                System.out.println("[17] Show All users borrowed books");
                System.out.println("[18] show a users borrowed books");
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
                nationalLibrary.showAllBooks(null);
            }
            if (choice == 2) {
                showBookInfo();
            }
            if (choice == 3) {
                borrowABook();
            }
            if (choice == 4) {
                findBookByTitle();
            }
            if (choice == 5) {
                findBookByAuthor();
            }
            if (choice == 6) {
                borrowBookIndefinitely();
            }
            if (choice == 7) {
                showMyBorrowedBooks();
            }
            if (choice == 8) {
                returnBorrowedBook();
            }
            if (choice == 9) {
                nationalLibrary.showAllBooks("True");
            }
            if (choice == 10) {
                sortByTitle();
            }
            if (choice == 11) {
                bookRemainingTime();
            }
            if (choice == 12) {
                nationalLibrary.showAllBooks("False");
            }
            if (choice == 13) {
                addNewBook();
            }
            if (choice == 14) {
                removeBook();
            }
            if (choice == 15) {
                nationalLibrary.showAllUsers();
            }
            if (choice == 16) {             //
                searchForUser();
            }
            if (choice == 17) {
                allUsersBorrowedBooks();
            }
            if (choice == 18) {
                userBorrowedBooks();
            }
            if (choice == 0) {
                break;
            }
        }
        System.out.print("Thank you and Goodbye..");
    }

    public void SetupLibrary() {

        ObjectSerializer fileObject;
        ArrayList<Book> savedBooks = null;
        ArrayList<User> savedUsers = null;

        fileObject = new ObjectSerializer(BOOKS_FILE);

        File dataFile = new File(BOOKS_FILE);
        if (dataFile.exists()) {

            savedBooks = (ArrayList<Book>) fileObject.ReadObjectFromFile();
        } else {

            savedBooks = Book.seedData();

            fileObject.WriteObjectToFile(savedBooks);
        }

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

        this.nationalLibrary = new Library(savedBooks, savedUsers);
    }

    private void saveDataBase(ArrayList arrayToSave, String FileName) {
        ObjectSerializer fileObject = new ObjectSerializer(FileName);
        File dataFile = new File(FileName);
        fileObject.WriteObjectToFile(arrayToSave);
    }

    public boolean Login() {
        System.out.println("\n     .:Welcome to the Library Login:. ");
        System.out.println("Please Enter your username:  ");
        String inpUser = scn.nextLine();

        System.out.println("Enter your Password: ");
        String inpPass = scn.nextLine();

        boolean loginStatus = false;
        loginStatus = nationalLibrary.Login(inpUser, inpPass);
        return loginStatus;

    }

    private void showBookInfo() {
        System.out.print("Enter a book title to show info: ");
        String bookTitle = scn.nextLine();
        System.out.println(nationalLibrary.showBookInfo(bookTitle));
    }

    private void borrowABook() {
        System.out.println("Enter a book title to borrow: ");
        String bookToBorrow = scn.nextLine();

        Book existingBook = nationalLibrary.borrowBook(bookToBorrow, false);
        if (existingBook != null) {
            System.out.println("Done.");
            saveDataBase(nationalLibrary.getBooks(), BOOKS_FILE);
            saveDataBase(nationalLibrary.getUsers(), USERS_FILE);
        } else {
            System.out.println("Unable to borrow book.");
        }
    }

    private void findBookByTitle() {
        System.out.println("Enter a book title to find: ");
        String titleToFind = scn.nextLine();
        System.out.println("Found:" + nationalLibrary.findBookByTitle(titleToFind));
    }

    private void findBookByAuthor() {
        System.out.println("Enter a book author to find: ");
        String authorToFind = scn.nextLine();
        System.out.println("Found:" + nationalLibrary.findBookByAuthor(authorToFind));
    }

    private void borrowBookIndefinitely() {
        System.out.println("Enter a book title to borrow: ");
        String bookToBorrow = scn.nextLine();

        Book existingBook = nationalLibrary.borrowBook(bookToBorrow, true);
        if (existingBook != null) {
            System.out.println("Done.");
            saveDataBase(nationalLibrary.getBooks(), BOOKS_FILE);
            saveDataBase(nationalLibrary.getUsers(), USERS_FILE);
        } else {
            System.out.println("Unable to borrow book.");
        }
    }

    private void showMyBorrowedBooks() {
        for (Book borrowedBook : nationalLibrary.showMyBorrowedBooks()) {
            System.out.println(borrowedBook);
        }
    }

    private void returnBorrowedBook() {
        Book selectedBook = null;

        for (Book borrowedBook : nationalLibrary.showMyBorrowedBooks()) {
            System.out.println("Book title: " + borrowedBook.getTitle());
        }

        System.out.print("Enter the book title: ");
        Scanner scan = new Scanner(System.in);
        String returnTitle = scan.nextLine();
        Book borrowedBook = nationalLibrary.returnBook( returnTitle);

        if (borrowedBook != null) {
            System.out.println("Book returned.");
            saveDataBase(nationalLibrary.getBooks(), BOOKS_FILE);
            saveDataBase(nationalLibrary.getUsers(), USERS_FILE);
        } else {
            System.out.println("Unable to return the book.");
        }
    }

    private void orderBookByTitle() {

    }

    private void bookRemainingTime() {
        Book selectedBook = null;

        for (Book borrowedBook : nationalLibrary.showMyBorrowedBooks()) {
            System.out.println("Book title: " + borrowedBook.getTitle());
        }

        System.out.print("Enter the book title: ");
        Scanner scan = new Scanner(System.in);
        String returnTitle = scan.nextLine();

        Book borrowedBook = nationalLibrary.searchBookList(returnTitle, BookFields.TITLE);

        if (borrowedBook != null) {
            LocalDate d1 = borrowedBook.getBorrowedDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate d2 = LocalDate.now();
            Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
            long diffDays = diff.toDays();

            System.out.println("Remaining days: " + (borrowedBook.getMaxBorrowingDays() - (int)diffDays));
        } else {
            System.out.println("Unable to calculate the book return.");
        }
    }

    private void sortByTitle() {
        nationalLibrary.getBooks().sort((t1, t2) -> {
            return t1.getTitle().compareTo(t2.getTitle());
        });
        for (Book book : nationalLibrary.getBooks()) {
                System.out.printf("Title: %s, category: %s, (Available  %s)\n", book.getTitle(), book.getBookCategory(), book.isAvailable() ? "Yes" : "No");
            System.out.println("....................................................");
        }
    }

    public void addNewBook() {

        if (!nationalLibrary.isAdmin()) {
            System.out.println("Choose a valid number!!");
            return;
        }

        System.out.print("Choose a category: 1.History 2.Biology 3.Novel 4.Science 5.Technology 6.Sports ");
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

        nationalLibrary.getBooks().add(new Book(BookCategory.values()[category - 1], title, author, description, true));

        System.out.println("    ..You have added new Book successfully!..");
    }

    public void removeBook() {

        if (!nationalLibrary.isAdmin()) {
            System.out.println("Choose a valid number!!");
            return;
        }
        System.out.print("Enter the book title to be removed: ");
        String title = scn.nextLine();
        nationalLibrary.removeBook(title);
        System.out.println("Done! '" + title + "' was removed successfully");
    }


    public void searchForUser() {

    }

    public void allUsersBorrowedBooks() {
        nationalLibrary.allUsersBorrowedBooks();
    }

    public void userBorrowedBooks() {
        nationalLibrary.showAllUsers();

        System.out.print("Enter a username to show borrowed books: ");
        String userName = scn.nextLine();
        nationalLibrary.userBorrowedBooks(userName);

    }


}

