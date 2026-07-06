package com.library;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LibraryService library = new LibraryService();

        while (true) {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Add Member");
            System.out.println("5. View Members");
            System.out.println("6. Issue Book");
            System.out.println("7. Return Book");
            System.out.println("8. View Issued Books");
            System.out.println("9. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Book Name: ");
                    String name = sc.nextLine();

                    System.out.print("Author: ");
                    String author = sc.nextLine();

                    System.out.print("Category: ");
                    String category = sc.nextLine();

                    System.out.print("Quantity: ");
                    int qty = sc.nextInt();

                    library.addBook(new Book(id, name, author, category, qty));
                    break;

                case 2:
                    library.viewBooks();
                    break;

                case 3:
                    System.out.print("Enter Book Name or Author: ");
                    sc.nextLine();
                    String search = sc.nextLine();
                    library.searchBook(search);
                    break;

                case 4:
                    System.out.print("Member ID: ");
                    int mid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Member Name: ");
                    String mname = sc.nextLine();

                    System.out.print("Mobile: ");
                    String mobile = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    library.addMember(new Member(mid, mname, mobile, email));
                    break;

                case 5:
                    library.viewMembers();
                    break;

                case 6:
                    System.out.print("Book ID: ");
                    int bid = sc.nextInt();

                    System.out.print("Member ID: ");
                    int memid = sc.nextInt();

                    library.issueBook(bid, memid);
                    break;

                case 7:
                    System.out.print("Book ID: ");
                    int rbId = sc.nextInt();

                    System.out.print("Member ID: ");
                    int rmId = sc.nextInt();

                    library.returnBook(rbId, rmId);
                    break;

                case 8:
                    library.viewIssuedBooks();
                    break;

                case 9:
                    System.out.println("Exiting System...");
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}